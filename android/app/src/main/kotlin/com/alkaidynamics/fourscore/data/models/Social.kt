package com.alkaidynamics.fourscore.data.models

import com.google.firebase.Timestamp
import java.util.Date

/**
 * Data class representing a social post
 * Contains all information needed to display a post in the social feed
 */
data class SocialPost(
    val id: String,
    val userId: String,
    val userName: String,
    val userAvatar: String? = null,
    val content: String,
    val imageUrl: String? = null,
    val videoUrl: String? = null,
    val likeCount: Int = 0,
    val commentCount: Int = 0,
    val isLiked: Boolean = false,
    val createdAt: Date = Date(),
    val timeAgo: String = "Just now",
    val workoutId: String? = null,
    val workoutName: String? = null
) {
    /**
     * Convert to Firestore data map
     */
    fun toMap(): Map<String, Any> {
        val map = mutableMapOf<String, Any>(
            "id" to id,
            "userId" to userId,
            "userName" to userName,
            "content" to content,
            "likeCount" to likeCount,
            "commentCount" to commentCount,
            "createdAt" to Timestamp(createdAt.time / 1000, 0)
        )
        
        userAvatar?.let { map["userAvatar"] = it }
        imageUrl?.let { map["imageUrl"] = it }
        videoUrl?.let { map["videoUrl"] = it }
        workoutId?.let { map["workoutId"] = it }
        workoutName?.let { map["workoutName"] = it }
        
        return map
    }
    
    companion object {
        /**
         * Create from Firestore data map
         */
        fun fromMap(data: Map<String, Any>, isLiked: Boolean = false): SocialPost {
            val createdAt = (data["createdAt"] as Timestamp).toDate()
            
            return SocialPost(
                id = data["id"] as String,
                userId = data["userId"] as String,
                userName = data["userName"] as String,
                userAvatar = data["userAvatar"] as? String,
                content = data["content"] as String,
                imageUrl = data["imageUrl"] as? String,
                videoUrl = data["videoUrl"] as? String,
                likeCount = (data["likeCount"] as Number).toInt(),
                commentCount = (data["commentCount"] as Number).toInt(),
                isLiked = isLiked,
                createdAt = createdAt,
                timeAgo = calculateTimeAgo(createdAt),
                workoutId = data["workoutId"] as? String,
                workoutName = data["workoutName"] as? String
            )
        }
        
        /**
         * Calculate time ago string from date
         * Provides user-friendly relative time
         */
        private fun calculateTimeAgo(date: Date): String {
            val now = Date()
            val diffInMillis = now.time - date.time
            val diffInSeconds = diffInMillis / 1000
            val diffInMinutes = diffInSeconds / 60
            val diffInHours = diffInMinutes / 60
            val diffInDays = diffInHours / 24
            
            return when {
                diffInSeconds < 60 -> "Just now"
                diffInMinutes < 60 -> "$diffInMinutes ${if (diffInMinutes == 1L) "minute" else "minutes"} ago"
                diffInHours < 24 -> "$diffInHours ${if (diffInHours == 1L) "hour" else "hours"} ago"
                diffInDays < 30 -> "$diffInDays ${if (diffInDays == 1L) "day" else "days"} ago"
                else -> {
                    val diffInMonths = diffInDays / 30
                    if (diffInMonths < 12) {
                        "$diffInMonths ${if (diffInMonths == 1L) "month" else "months"} ago"
                    } else {
                        val diffInYears = diffInMonths / 12
                        "$diffInYears ${if (diffInYears == 1L) "year" else "years"} ago"
                    }
                }
            }
        }
    }
}

/**
 * Data class representing a comment on a social post
 */
data class Comment(
    val id: String,
    val postId: String,
    val userId: String,
    val userName: String,
    val userAvatar: String? = null,
    val content: String,
    val createdAt: Date = Date(),
    val timeAgo: String = "Just now"
)

/**
 * Data class representing a fitness challenge
 * Contains all information needed to display and participate in a challenge
 */
data class Challenge(
    val id: String,
    val title: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val startDateObj: Date,
    val endDateObj: Date,
    val creatorId: String,
    val creatorName: String,
    val participantCount: Int = 0,
    val isJoined: Boolean = false,
    val progress: Float = 0f,
    val goal: Int = 0,
    val goalUnit: String = "",
    val type: ChallengeType = ChallengeType.DISTANCE,
    val isPublic: Boolean = true
)

/**
 * Enum representing challenge types
 */
enum class ChallengeType {
    DISTANCE,
    STEPS,
    WORKOUTS,
    CALORIES,
    WEIGHT,
    CUSTOM
}
