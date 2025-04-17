package com.alkaidynamics.fourscore.ui.screens.forge

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alkaidynamics.fourscore.ui.components.ModuleHeader
import com.alkaidynamics.fourscore.ui.components.WorkoutCard
import com.alkaidynamics.fourscore.ui.viewmodels.ForgeViewModel

/**
 * Forge screen component (Exercise/Workouts module)
 * Implements accessibility-first approach with clear visual feedback and organization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgeScreen(
    onBackClick: () -> Unit,
    viewModel: ForgeViewModel = viewModel()
) {
    // State
    val isLoading by viewModel.isLoading.collectAsState()
    val workouts by viewModel.workouts.collectAsState()
    
    // Load workouts
    LaunchedEffect(Unit) {
        viewModel.loadWorkouts()
    }
    
    // Main content
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Forge - Workouts") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Open search */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* Open filter */ }) {
                        Icon(Icons.Default.FilterList, contentDescription = "Filter")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Create new workout */ },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Workout")
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
                    title = "Forge Your Strength",
                    subtitle = "Track workouts, build routines, and monitor progress",
                    icon = Icons.Default.FitnessCenter,
                    color = MaterialTheme.colorScheme.primary
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Today's workout section
                Text(
                    text = "TODAY'S WORKOUT",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                if (workouts.isNotEmpty()) {
                    WorkoutCard(
                        title = workouts[0].name,
                        description = workouts[0].description,
                        exercises = workouts[0].exercises.size,
                        duration = workouts[0].estimatedDuration,
                        onClick = { /* Open workout details */ }
                    )
                } else {
                    // No workout scheduled
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
                                Icons.Default.AddCircle,
                                contentDescription = "Add Workout",
                                modifier = Modifier.size(48.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Text(
                                text = "No Workout Scheduled",
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Text(
                                text = "Tap to create or select a workout for today",
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Button(
                                onClick = { /* Create workout */ },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Create Workout")
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // My routines section
                Text(
                    text = "MY ROUTINES",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                // Display workout list
                workouts.forEach { workout ->
                    WorkoutCard(
                        title = workout.name,
                        description = workout.description,
                        exercises = workout.exercises.size,
                        duration = workout.estimatedDuration,
                        onClick = { /* Open workout details */ }
                    )
                    
                    Spacer(modifier = Modifier.height(12.dp))
                }
                
                // Show empty state if no workouts
                if (workouts.isEmpty() && !isLoading) {
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
                            Text(
                                text = "No Routines Found",
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Text(
                                text = "Create your first workout routine to get started",
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
            
            // Loading indicator
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}
