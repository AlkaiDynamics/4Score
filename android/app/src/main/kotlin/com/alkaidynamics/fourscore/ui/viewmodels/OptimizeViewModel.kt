package com.alkaidynamics.fourscore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkaidynamics.fourscore.data.models.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

/**
 * ViewModel for the Optimize module (Nutrition)
 * Implements accessibility-first approach with clear loading states and error handling
 */
class OptimizeViewModel : ViewModel() {
    // Nutrition data
    private val _dailyNutrition = MutableStateFlow(DailyNutrition())
    val dailyNutrition: StateFlow<DailyNutrition> = _dailyNutrition.asStateFlow()
    
    private val _mealPlan = MutableStateFlow(MealPlan("today"))
    val mealPlan: StateFlow<MealPlan> = _mealPlan.asStateFlow()
    
    // Loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // Error state
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    /**
     * Load nutrition data from Firestore
     * Currently uses mock data for demonstration
     */
    fun loadNutritionData() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            try {
                // Simulate network delay
                delay(1500)
                
                // Mock data - will be replaced with Firestore data
                val mockNutrition = createMockNutrition()
                _dailyNutrition.value = mockNutrition
                
                val mockMealPlan = createMockMealPlan()
                _mealPlan.value = mockMealPlan
            } catch (e: Exception) {
                _error.value = "Error loading nutrition data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Create mock nutrition data for demonstration
     * Will be replaced with actual Firestore data
     */
    private fun createMockNutrition(): DailyNutrition {
        return DailyNutrition(
            date = Date(),
            caloriesConsumed = 1450,
            caloriesGoal = 2200,
            proteinConsumed = 95,
            proteinGoal = 150,
            carbsConsumed = 120,
            carbsGoal = 220,
            fatConsumed = 45,
            fatGoal = 70,
            waterConsumed = 1500,
            waterGoal = 2500
        )
    }
    
    /**
     * Create mock meal plan data for demonstration
     * Will be replaced with actual Firestore data
     */
    private fun createMockMealPlan(): MealPlan {
        val timeFormat = SimpleDateFormat("h:mm a", Locale.US)
        
        // Mock foods
        val eggs = Food(
            id = "eggs",
            name = "Eggs",
            calories = 70,
            protein = 6,
            carbs = 0,
            fat = 5,
            servingSize = "1",
            servingUnit = "large egg"
        )
        
        val oatmeal = Food(
            id = "oatmeal",
            name = "Oatmeal",
            calories = 150,
            protein = 5,
            carbs = 27,
            fat = 3,
            servingSize = "1",
            servingUnit = "cup"
        )
        
        val chicken = Food(
            id = "chicken",
            name = "Grilled Chicken Breast",
            calories = 165,
            protein = 31,
            carbs = 0,
            fat = 3,
            servingSize = "3",
            servingUnit = "oz"
        )
        
        val rice = Food(
            id = "rice",
            name = "Brown Rice",
            calories = 215,
            protein = 5,
            carbs = 45,
            fat = 2,
            servingSize = "1",
            servingUnit = "cup"
        )
        
        val salmon = Food(
            id = "salmon",
            name = "Baked Salmon",
            calories = 175,
            protein = 19,
            carbs = 0,
            fat = 11,
            servingSize = "3",
            servingUnit = "oz"
        )
        
        val sweetPotato = Food(
            id = "sweet-potato",
            name = "Sweet Potato",
            calories = 115,
            protein = 2,
            carbs = 27,
            fat = 0,
            servingSize = "1",
            servingUnit = "medium"
        )
        
        // Mock meals
        val breakfast = Meal(
            id = "breakfast",
            name = "Breakfast",
            calories = 290,
            protein = 17,
            carbs = 27,
            fat = 13,
            time = "7:30 AM",
            foods = listOf(eggs, eggs, oatmeal)
        )
        
        val lunch = Meal(
            id = "lunch",
            name = "Lunch",
            calories = 380,
            protein = 36,
            carbs = 45,
            fat = 5,
            time = "12:30 PM",
            foods = listOf(chicken, rice)
        )
        
        val dinner = Meal(
            id = "dinner",
            name = "Dinner",
            calories = 290,
            protein = 21,
            carbs = 27,
            fat = 11,
            time = "6:30 PM",
            foods = listOf(salmon, sweetPotato)
        )
        
        // Create meal plan
        return MealPlan(
            id = "today",
            date = Date(),
            meals = listOf(breakfast, lunch, dinner)
        )
    }
}
