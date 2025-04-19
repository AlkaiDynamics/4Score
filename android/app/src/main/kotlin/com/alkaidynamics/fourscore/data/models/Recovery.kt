package com.alkaidynamics.fourscore.data.models

import com.google.firebase.Timestamp
import java.util.Date

/**
 * Data class representing sleep data
 * Contains all information about sleep quality and duration
 */
data class SleepData(
    val id: String,
    val userId: String,
    val date: Date,
    val bedtime: Date,
    val wakeTime: Date,
    val duration: Long, // in minutes
    val quality: Int, // 1-10 scale
    val notes: String = "",
    // Formatted values for display
    val lastNightDuration: String = formatDuration(duration),
    val lastNightQuality: Int = quality,
    val lastNightBedtime: String = formatTime(bedtime),
    val weeklyQuality: List<Pair<String, Int>> = emptyList(),
    val tips: List<String> = defaultSleepTips
) {
    /**
     * Convert to Firestore data map
     */
    fun toMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "userId" to userId,
            "date" to Timestamp(date.time / 1000, 0),
            "bedtime" to Timestamp(bedtime.time / 1000, 0),
            "wakeTime" to Timestamp(wakeTime.time / 1000, 0),
            "duration" to duration,
            "quality" to quality,
            "notes" to notes
        )
    }
    
    companion object {
        /**
         * Create from Firestore data map
         */
        fun fromMap(data: Map<String, Any>): SleepData {
            val date = (data["date"] as Timestamp).toDate()
            val bedtime = (data["bedtime"] as Timestamp).toDate()
            val wakeTime = (data["wakeTime"] as Timestamp).toDate()
            val duration = (data["duration"] as Number).toLong()
            val quality = (data["quality"] as Number).toInt()
            
            return SleepData(
                id = data["id"] as String,
                userId = data["userId"] as String,
                date = date,
                bedtime = bedtime,
                wakeTime = wakeTime,
                duration = duration,
                quality = quality,
                notes = data["notes"] as? String ?: "",
                lastNightDuration = formatDuration(duration),
                lastNightQuality = quality,
                lastNightBedtime = formatTime(bedtime)
            )
        }
        
        /**
         * Format duration in minutes to hours and minutes
         */
        private fun formatDuration(minutes: Long): String {
            val hours = minutes / 60
            val mins = minutes % 60
            return "$hours hr ${mins} min"
        }
        
        /**
         * Format time to 12-hour format
         */
        private fun formatTime(date: Date): String {
            val hours = date.hours
            val minutes = date.minutes
            val amPm = if (hours < 12) "AM" else "PM"
            val hour12 = if (hours % 12 == 0) 12 else hours % 12
            return String.format("%d:%02d %s", hour12, minutes, amPm)
        }
        
        /**
         * Default sleep tips
         */
        private val defaultSleepTips = listOf(
            "Maintain a consistent sleep schedule, even on weekends",
            "Create a relaxing bedtime routine to signal your body it's time to sleep",
            "Keep your bedroom cool, dark, and quiet for optimal sleep conditions",
            "Avoid caffeine, alcohol, and large meals before bedtime",
            "Limit screen time at least 1 hour before bed to reduce blue light exposure"
        )
    }
}

/**
 * Data class representing a recovery activity
 * Contains all information about recovery methods and their effectiveness
 */
data class RecoveryActivity(
    val id: String,
    val userId: String,
    val name: String,
    val description: String,
    val category: String,
    val date: String,
    val duration: String,
    val rating: Int, // 1-5 scale
    val notes: String = ""
) {
    /**
     * Convert to Firestore data map
     */
    fun toMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "userId" to userId,
            "name" to name,
            "description" to description,
            "category" to category,
            "date" to date,
            "duration" to duration,
            "rating" to rating,
            "notes" to notes
        )
    }
    
    companion object {
        /**
         * Create from Firestore data map
         */
        fun fromMap(data: Map<String, Any>): RecoveryActivity {
            return RecoveryActivity(
                id = data["id"] as String,
                userId = data["userId"] as String,
                name = data["name"] as String,
                description = data["description"] as String,
                category = data["category"] as String,
                date = data["date"] as String,
                duration = data["duration"] as String,
                rating = (data["rating"] as Number).toInt(),
                notes = data["notes"] as? String ?: ""
            )
        }
    }
}
