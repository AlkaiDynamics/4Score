package com.alkaidynamics.fourscore.data.models

import com.google.firebase.Timestamp
import java.util.Date

/**
 * Data class representing a meal
 * Contains all information needed to display and track a meal
 */
data class Meal(
    val id: String,
    val name: String,
    val calories: Int,
    val protein: Int,
    val carbs: Int,
    val fat: Int,
    val time: String,
    val date: Date = Date(),
    val foods: List<Food> = emptyList(),
    val userId: String? = null,
    val notes: String = ""
) {
    /**
     * Convert to Firestore data map
     */
    fun toMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "name" to name,
            "calories" to calories,
            "protein" to protein,
            "carbs" to carbs,
            "fat" to fat,
            "time" to time,
            "date" to Timestamp(date.time / 1000, 0),
            "foodIds" to foods.map { it.id },
            "userId" to (userId ?: ""),
            "notes" to notes
        )
    }
    
    companion object {
        /**
         * Create from Firestore data map
         * Note: This requires a separate query to fetch the foods
         */
        fun fromMap(data: Map<String, Any>, foods: List<Food> = emptyList()): Meal {
            return Meal(
                id = data["id"] as String,
                name = data["name"] as String,
                calories = (data["calories"] as Number).toInt(),
                protein = (data["protein"] as Number).toInt(),
                carbs = (data["carbs"] as Number).toInt(),
                fat = (data["fat"] as Number).toInt(),
                time = data["time"] as String,
                date = (data["date"] as Timestamp).toDate(),
                foods = foods,
                userId = data["userId"] as? String,
                notes = data["notes"] as? String ?: ""
            )
        }
    }
}

/**
 * Data class representing a food item
 * Contains all nutritional information for a food
 */
data class Food(
    val id: String,
    val name: String,
    val calories: Int,
    val protein: Int,
    val carbs: Int,
    val fat: Int,
    val servingSize: String,
    val servingUnit: String,
    val barcode: String? = null,
    val imageUrl: String? = null,
    val isCustom: Boolean = false,
    val userId: String? = null
) {
    /**
     * Convert to Firestore data map
     */
    fun toMap(): Map<String, Any> {
        val map = mutableMapOf<String, Any>(
            "id" to id,
            "name" to name,
            "calories" to calories,
            "protein" to protein,
            "carbs" to carbs,
            "fat" to fat,
            "servingSize" to servingSize,
            "servingUnit" to servingUnit,
            "isCustom" to isCustom
        )
        
        barcode?.let { map["barcode"] = it }
        imageUrl?.let { map["imageUrl"] = it }
        userId?.let { map["userId"] = it }
        
        return map
    }
    
    companion object {
        /**
         * Create from Firestore data map
         */
        fun fromMap(data: Map<String, Any>): Food {
            return Food(
                id = data["id"] as String,
                name = data["name"] as String,
                calories = (data["calories"] as Number).toInt(),
                protein = (data["protein"] as Number).toInt(),
                carbs = (data["carbs"] as Number).toInt(),
                fat = (data["fat"] as Number).toInt(),
                servingSize = data["servingSize"] as String,
                servingUnit = data["servingUnit"] as String,
                barcode = data["barcode"] as? String,
                imageUrl = data["imageUrl"] as? String,
                isCustom = data["isCustom"] as? Boolean ?: false,
                userId = data["userId"] as? String
            )
        }
    }
}

/**
 * Data class representing a meal plan
 * Contains all meals for a specific day
 */
data class MealPlan(
    val id: String,
    val date: Date = Date(),
    val meals: List<Meal> = emptyList(),
    val userId: String? = null,
    val totalCalories: Int = meals.sumOf { it.calories },
    val totalProtein: Int = meals.sumOf { it.protein },
    val totalCarbs: Int = meals.sumOf { it.carbs },
    val totalFat: Int = meals.sumOf { it.fat }
)

/**
 * Data class representing daily nutrition summary
 * Contains all nutrition information for a specific day
 */
data class DailyNutrition(
    val date: Date = Date(),
    val caloriesConsumed: Int = 0,
    val caloriesGoal: Int = 2000,
    val caloriesRemaining: Int = caloriesGoal - caloriesConsumed,
    val proteinConsumed: Int = 0,
    val proteinGoal: Int = 150,
    val carbsConsumed: Int = 0,
    val carbsGoal: Int = 200,
    val fatConsumed: Int = 0,
    val fatGoal: Int = 65,
    val waterConsumed: Int = 0, // in ml
    val waterGoal: Int = 2500 // in ml
)
