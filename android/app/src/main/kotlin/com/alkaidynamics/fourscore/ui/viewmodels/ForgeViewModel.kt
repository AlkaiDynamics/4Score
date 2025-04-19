package com.alkaidynamics.fourscore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkaidynamics.fourscore.data.models.Exercise
import com.alkaidynamics.fourscore.data.models.Workout
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Forge module (Exercise/Workouts)
 * Implements accessibility-first approach with clear loading states and error handling
 */
class ForgeViewModel : ViewModel() {
    // Workout data
    private val _workouts = MutableStateFlow<List<Workout>>(emptyList())
    val workouts: StateFlow<List<Workout>> = _workouts.asStateFlow()
    
    // Loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // Error state
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    /**
     * Load workouts from Firestore
     * Currently uses mock data for demonstration
     */
    fun loadWorkouts() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            try {
                // Simulate network delay
                delay(1500)
                
                // Mock data - will be replaced with Firestore data
                val mockWorkouts = createMockWorkouts()
                _workouts.value = mockWorkouts
            } catch (e: Exception) {
                _error.value = "Error loading workouts: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Create mock workout data for demonstration
     * Will be replaced with actual Firestore data
     */
    private fun createMockWorkouts(): List<Workout> {
        // Mock exercises
        val chestExercises = listOf(
            Exercise(
                id = "bench-press",
                name = "Bench Press",
                muscleGroup = "Chest",
                equipment = "Barbell",
                instructions = "Lie on a flat bench, grip the bar with hands slightly wider than shoulder-width. Lower the bar to your chest, then press it back up."
            ),
            Exercise(
                id = "incline-press",
                name = "Incline Dumbbell Press",
                muscleGroup = "Upper Chest",
                equipment = "Dumbbells",
                instructions = "Lie on an incline bench, hold dumbbells at shoulder level, press them up and together."
            ),
            Exercise(
                id = "chest-fly",
                name = "Dumbbell Fly",
                muscleGroup = "Chest",
                equipment = "Dumbbells",
                instructions = "Lie on a flat bench, hold dumbbells above chest with slight bend in elbows, lower arms out to sides."
            )
        )
        
        val legExercises = listOf(
            Exercise(
                id = "squat",
                name = "Barbell Squat",
                muscleGroup = "Quadriceps",
                equipment = "Barbell",
                instructions = "Place barbell on upper back, feet shoulder-width apart, bend knees and hips to lower body, then return to standing."
            ),
            Exercise(
                id = "leg-press",
                name = "Leg Press",
                muscleGroup = "Quadriceps",
                equipment = "Machine",
                instructions = "Sit in leg press machine, press platform away by extending knees, then return to starting position."
            ),
            Exercise(
                id = "lunges",
                name = "Walking Lunges",
                muscleGroup = "Quadriceps, Glutes",
                equipment = "Dumbbells (optional)",
                instructions = "Step forward with one leg, lower body until both knees are bent at 90 degrees, then step forward with other leg."
            )
        )
        
        // Mock workouts
        return listOf(
            Workout(
                id = "chest-day",
                name = "Chest Day",
                description = "Focus on chest development with compound and isolation exercises",
                exercises = chestExercises,
                estimatedDuration = 45
            ),
            Workout(
                id = "leg-day",
                name = "Leg Day",
                description = "Build lower body strength and muscle with these key exercises",
                exercises = legExercises,
                estimatedDuration = 60
            )
        )
    }
}
