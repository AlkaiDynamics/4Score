package com.alkaidynamics.fourscore.data.models

/**
 * Data class representing an exercise
 * Contains all information needed to display and perform an exercise
 */
data class Exercise(
    val id: String,
    val name: String,
    val muscleGroup: String,
    val equipment: String,
    val instructions: String,
    val imageUrl: String? = null,
    val videoUrl: String? = null,
    val isCustom: Boolean = false,
    val difficulty: ExerciseDifficulty = ExerciseDifficulty.INTERMEDIATE
)

/**
 * Enum representing exercise difficulty levels
 */
enum class ExerciseDifficulty {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED,
    EXPERT
}
