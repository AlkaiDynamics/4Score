package com.alkaidynamics.fourscore.ui.screens.optimize

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alkaidynamics.fourscore.ui.components.MacroProgressBar
import com.alkaidynamics.fourscore.ui.components.ModuleHeader
import com.alkaidynamics.fourscore.ui.components.NutritionCard
import com.alkaidynamics.fourscore.ui.viewmodels.OptimizeViewModel

/**
 * Optimize screen component (Nutrition module)
 * Implements accessibility-first approach with clear visual feedback and organization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptimizeScreen(
    onBackClick: () -> Unit,
    viewModel: OptimizeViewModel = viewModel()
) {
    // State
    val isLoading by viewModel.isLoading.collectAsState()
    val dailyNutrition by viewModel.dailyNutrition.collectAsState()
    val mealPlan by viewModel.mealPlan.collectAsState()
    
    // Load nutrition data
    LaunchedEffect(Unit) {
        viewModel.loadNutritionData()
    }
    
    // Main content
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Optimize - Nutrition") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Open calendar */ }) {
                        Icon(Icons.Default.CalendarToday, contentDescription = "Calendar")
                    }
                    IconButton(onClick = { /* Open settings */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Log meal */ },
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Log Meal")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Main content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                // Module header
                ModuleHeader(
                    title = "Optimize Your Nutrition",
                    subtitle = "Track meals, monitor macros, and plan your diet",
                    icon = Icons.Default.Restaurant,
                    color = MaterialTheme.colorScheme.secondary
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Daily summary
                Text(
                    text = "TODAY'S SUMMARY",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Calories card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Calories",
                            style = MaterialTheme.typography.titleMedium
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = "${dailyNutrition.caloriesConsumed}",
                                style = MaterialTheme.typography.headlineLarge,
                                color = MaterialTheme.colorScheme.secondary
                            )
                            
                            Text(
                                text = " / ${dailyNutrition.caloriesGoal}",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        LinearProgressIndicator(
                            progress = (dailyNutrition.caloriesConsumed.toFloat() / dailyNutrition.caloriesGoal).coerceIn(0f, 1f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp),
                            color = MaterialTheme.colorScheme.secondary
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "${dailyNutrition.caloriesRemaining} calories remaining",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                
                // Macros section
                Text(
                    text = "MACRONUTRIENTS",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Macros card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        // Protein
                        MacroProgressBar(
                            label = "Protein",
                            consumed = dailyNutrition.proteinConsumed,
                            goal = dailyNutrition.proteinGoal,
                            unit = "g",
                            color = Color(0xFF4CAF50) // Green
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Carbs
                        MacroProgressBar(
                            label = "Carbs",
                            consumed = dailyNutrition.carbsConsumed,
                            goal = dailyNutrition.carbsGoal,
                            unit = "g",
                            color = Color(0xFFFFC107) // Amber
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Fat
                        MacroProgressBar(
                            label = "Fat",
                            consumed = dailyNutrition.fatConsumed,
                            goal = dailyNutrition.fatGoal,
                            unit = "g",
                            color = Color(0xFF2196F3) // Blue
                        )
                    }
                }
                
                // Meal plan section
                Text(
                    text = "TODAY'S MEAL PLAN",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Display meal plan
                if (mealPlan.meals.isNotEmpty()) {
                    mealPlan.meals.forEach { meal ->
                        NutritionCard(
                            title = meal.name,
                            calories = meal.calories,
                            protein = meal.protein,
                            carbs = meal.carbs,
                            fat = meal.fat,
                            time = meal.time,
                            onClick = { /* Open meal details */ }
                        )
                        
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                } else {
                    // No meals planned
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.RestaurantMenu,
                                contentDescription = "No Meals",
                                modifier = Modifier.size(48.dp),
                                tint = MaterialTheme.colorScheme.secondary
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Text(
                                text = "No Meals Planned",
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Text(
                                text = "Create a meal plan to track your nutrition goals",
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Button(
                                onClick = { /* Create meal plan */ },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.secondary
                                )
                            ) {
                                Text("Create Meal Plan")
                            }
                        }
                    }
                }
            }
            
            // Loading indicator
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
