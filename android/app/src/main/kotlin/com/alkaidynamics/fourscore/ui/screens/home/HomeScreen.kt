package com.alkaidynamics.fourscore.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alkaidynamics.fourscore.ui.viewmodels.HomeViewModel

/**
 * Home screen component
 * Central hub for accessing the F.O.U.R. modules
 * Implements accessibility-first approach with clear visual feedback and organization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onForgeClick: () -> Unit,
    onOptimizeClick: () -> Unit,
    onUniteClick: () -> Unit,
    onRecoverClick: () -> Unit,
    onProfileClick: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    // State
    val userName by viewModel.userName.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    
    // Load user data
    LaunchedEffect(Unit) {
        viewModel.loadUserData()
    }
    
    // Main content
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("4-Score Fitness") },
                actions = {
                    IconButton(onClick = onProfileClick) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Profile"
                        )
                    }
                }
            )
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
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Welcome message
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (isLoading) "Welcome" else "Welcome, ${userName.ifEmpty { "Fitness Champion" }}",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "Where Freedom Meets Fitness",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                
                // F.O.U.R. modules heading
                Text(
                    text = "F.O.U.R. MODULES",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Start
                )
                
                // F.O.U.R. modules grid
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Forge module
                    ModuleCard(
                        title = "Forge",
                        description = "Workouts & Exercises",
                        icon = Icons.Default.FitnessCenter,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(1f),
                        onClick = onForgeClick
                    )
                    
                    Spacer(modifier = Modifier.width(16.dp))
                    
                    // Optimize module
                    ModuleCard(
                        title = "Optimize",
                        description = "Nutrition & Diet",
                        icon = Icons.Default.Restaurant,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.weight(1f),
                        onClick = onOptimizeClick
                    )
                }
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Unite module
                    ModuleCard(
                        title = "Unite",
                        description = "Social & Community",
                        icon = Icons.Default.Group,
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.weight(1f),
                        onClick = onUniteClick
                    )
                    
                    Spacer(modifier = Modifier.width(16.dp))
                    
                    // Recover module
                    ModuleCard(
                        title = "Recover",
                        description = "Rest & Rejuvenation",
                        icon = Icons.Default.Bedtime,
                        color = Color(0xFF96854A), // Metallic Gold
                        modifier = Modifier.weight(1f),
                        onClick = onRecoverClick
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Quick access section
                Text(
                    text = "QUICK ACCESS",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Start
                )
                
                // Quick access items
                QuickAccessItem(
                    title = "Today's Workout",
                    icon = Icons.Default.DirectionsRun,
                    onClick = onForgeClick
                )
                
                QuickAccessItem(
                    title = "Meal Plan",
                    icon = Icons.Default.SetMeal,
                    onClick = onOptimizeClick
                )
                
                QuickAccessItem(
                    title = "Progress Tracker",
                    icon = Icons.Default.ShowChart,
                    onClick = { /* Navigate to progress tracker */ }
                )
                
                QuickAccessItem(
                    title = "Community Challenges",
                    icon = Icons.Default.EmojiEvents,
                    onClick = onUniteClick
                )
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

/**
 * Module card component for F.O.U.R. pillars
 * Large, easily tappable cards with clear visual distinction
 */
@Composable
fun ModuleCard(
    title: String,
    description: String,
    icon: ImageVector,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(160.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = color.copy(alpha = 0.8f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                icon,
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

/**
 * Quick access item component
 * Large tap targets with clear visual feedback
 */
@Composable
fun QuickAccessItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        Icon(
            Icons.Default.ChevronRight,
            contentDescription = "Open",
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
