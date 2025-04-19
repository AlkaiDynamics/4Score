package com.alkaidynamics.fourscore.data.models

import com.google.firebase.Timestamp
import java.util.Date

/**
 * Data class representing a workout
 * Contains all information needed to display and perform a workout
 */
data class Workout(
    val id: String,
    val name: String,
    val description: String,
    val exercises: List<Exercise>,
    val estimatedDuration: Int, // in minutes
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val userId: String? = null,
    val isPublic: Boolean = false,
    val tags: List<String> = emptyList(),
    val difficulty: WorkoutDifficulty = WorkoutDifficulty.INTERMEDIATE
) {
    /**
     * Convert to Firestore data map
     */
    fun toMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "name" to name,
            "description" to description,
            "exerciseIds" to exercises.map { it.id },
            "estimatedDuration" to estimatedDuration,
            "createdAt" to Timestamp(createdAt.time / 1000, 0),
            "updatedAt" to Timestamp(updatedAt.time / 1000, 0),
            "userId" to (userId ?: ""),
            "isPublic" to isPublic,
            "tags" to tags,
            "difficulty" to difficulty.name
        )
    }
    
    companion object {
        /**
         * Create from Firestore data map
         * Note: This requires a separate query to fetch the exercises
         */
        fun fromMap(data: Map<String, Any>, exercises: List<Exercise> = emptyList()): Workout {
            return Workout(
                id = data["id"] as String,
                name = data["name"] as String,
                description = data["description"] as String,
                exercises = exercises,
                estimatedDuration = (data["estimatedDuration"] as Number).toInt(),
                createdAt = (data["createdAt"] as Timestamp).toDate(),
                updatedAt = (data["updatedAt"] as Timestamp).toDate(),
                userId = data["userId"] as? String,
                isPublic = data["isPublic"] as? Boolean ?: false,
                tags = (data["tags"] as? List<*>)?.filterIsInstance<String>() ?: emptyList(),
                difficulty = try {
                    WorkoutDifficulty.valueOf(data["difficulty"] as String)
                } catch (e: Exception) {
                    WorkoutDifficulty.INTERMEDIATE
                }
            )
        }
    }
}

/**
 * Enum representing workout difficulty levels
 */
enum class WorkoutDifficulty {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED,
    EXPERT
}
