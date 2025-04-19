package com.alkaidynamics.fourscore.ui.screens.recover

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
import com.alkaidynamics.fourscore.ui.components.ModuleHeader
import com.alkaidynamics.fourscore.ui.components.RecoveryCard
import com.alkaidynamics.fourscore.ui.components.SleepQualityChart
import com.alkaidynamics.fourscore.ui.viewmodels.RecoverViewModel

/**
 * Recover screen component (Rest & Recovery module)
 * Implements accessibility-first approach with clear visual feedback and organization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecoverScreen(
    onBackClick: () -> Unit,
    viewModel: RecoverViewModel = viewModel()
) {
    // State
    val isLoading by viewModel.isLoading.collectAsState()
    val sleepData by viewModel.sleepData.collectAsState()
    val recoveryActivities by viewModel.recoveryActivities.collectAsState()
    val selectedTab by viewModel.selectedTab.collectAsState()
    
    // Load recovery data
    LaunchedEffect(Unit) {
        viewModel.loadRecoveryData()
    }
    
    // Main content
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recover - Rest & Rejuvenation") },
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
                onClick = { /* Log recovery activity */ },
                containerColor = Color(0xFF96854A) // Metallic Gold
            ) {
                Icon(Icons.Default.Add, contentDescription = "Log Recovery")
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
                    title = "Recover & Rejuvenate",
                    subtitle = "Track sleep, monitor recovery, and optimize rest",
                    icon = Icons.Default.Bedtime,
                    color = Color(0xFF96854A) // Metallic Gold
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // Tab navigation
                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = Color(0xFF96854A) // Metallic Gold
                ) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { viewModel.selectTab(0) },
                        text = { Text("Sleep") },
                        icon = { Icon(Icons.Default.Bedtime, contentDescription = null) }
                    )
                    
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { viewModel.selectTab(1) },
                        text = { Text("Recovery") },
                        icon = { Icon(Icons.Default.SelfImprovement, contentDescription = null) }
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Tab content
                when (selectedTab) {
                    // Sleep tab
                    0 -> {
                        // Sleep summary
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Last Night's Sleep",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                
                                Spacer(modifier = Modifier.height(16.dp))
                                
                                // Sleep metrics
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    // Duration
                                    SleepMetric(
                                        icon = Icons.Default.AccessTime,
                                        value = sleepData.lastNightDuration,
                                        label = "Duration"
                                    )
                                    
                                    // Quality
                                    SleepMetric(
                                        icon = Icons.Default.Star,
                                        value = "${sleepData.lastNightQuality}/10",
                                        label = "Quality"
                                    )
                                    
                                    // Bedtime
                                    SleepMetric(
                                        icon = Icons.Default.NightsStay,
                                        value = sleepData.lastNightBedtime,
                                        label = "Bedtime"
                                    )
                                }
                                
                                Spacer(modifier = Modifier.height(16.dp))
                                
                                // Log sleep button
                                Button(
                                    onClick = { /* Log sleep */ },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF96854A) // Metallic Gold
                                    )
                                ) {
                                    Icon(Icons.Default.Add, contentDescription = null)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Log Sleep")
                                }
                            }
                        }
                        
                        // Sleep quality chart
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Sleep Quality Trend",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                
                                Spacer(modifier = Modifier.height(16.dp))
                                
                                // Sleep quality chart
                                SleepQualityChart(
                                    data = sleepData.weeklyQuality,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)
                                )
                                
                                Spacer(modifier = Modifier.height(8.dp))
                                
                                // Chart legend
                                Text(
                                    text = "Last 7 Days",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                        
                        // Sleep tips
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Sleep Tips",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                
                                Spacer(modifier = Modifier.height(8.dp))
                                
                                // Tips list
                                sleepData.tips.forEach { tip ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Icon(
                                            Icons.Default.Lightbulb,
                                            contentDescription = null,
                                            tint = Color(0xFF96854A), // Metallic Gold
                                            modifier = Modifier.padding(top = 2.dp)
                                        )
                                        
                                        Spacer(modifier = Modifier.width(8.dp))
                                        
                                        Text(
                                            text = tip,
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                    }
                                }
                            }
                        }
                    }
                    
                    // Recovery tab
                    1 -> {
                        // Recovery activities
                        Text(
                            text = "RECOVERY ACTIVITIES",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        
                        if (recoveryActivities.isEmpty() && !isLoading) {
                            // No activities
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
                                        Icons.Default.SelfImprovement,
                                        contentDescription = "No Activities",
                                        modifier = Modifier.size(48.dp),
                                        tint = Color(0xFF96854A) // Metallic Gold
                                    )
                                    
                                    Spacer(modifier = Modifier.height(8.dp))
                                    
                                    Text(
                                        text = "No Recovery Activities",
                                        style = MaterialTheme.typography.titleMedium,
                                        textAlign = TextAlign.Center
                                    )
                                    
                                    Spacer(modifier = Modifier.height(8.dp))
                                    
                                    Text(
                                        text = "Log your first recovery activity to start tracking your rest and rejuvenation",
                                        style = MaterialTheme.typography.bodyMedium,
                                        textAlign = TextAlign.Center
                                    )
                                    
                                    Spacer(modifier = Modifier.height(8.dp))
                                    
                                    Button(
                                        onClick = { /* Log recovery activity */ },
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color(0xFF96854A) // Metallic Gold
                                        )
                                    ) {
                                        Text("Log Recovery Activity")
                                    }
                                }
                            }
                        } else {
                            // Display recovery activities
                            recoveryActivities.forEach { activity ->
                                RecoveryCard(
                                    title = activity.name,
                                    description = activity.description,
                                    duration = activity.duration,
                                    date = activity.date,
                                    category = activity.category,
                                    rating = activity.rating,
                                    onClick = { /* View activity details */ },
                                    modifier = Modifier.padding(bottom = 16.dp)
                                )
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        // Recovery suggestions
                        Text(
                            text = "SUGGESTED ACTIVITIES",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        
                        // Suggested activities list
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                listOf(
                                    "Gentle Yoga - 20 minutes" to "Improve flexibility and reduce stress",
                                    "Foam Rolling - 15 minutes" to "Release muscle tension and improve circulation",
                                    "Meditation - 10 minutes" to "Reduce stress and improve mental recovery",
                                    "Epsom Salt Bath - 20 minutes" to "Relieve muscle soreness and promote relaxation"
                                ).forEach { (title, description) ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            Icons.Default.SelfImprovement,
                                            contentDescription = null,
                                            tint = Color(0xFF96854A), // Metallic Gold
                                            modifier = Modifier.size(24.dp)
                                        )
                                        
                                        Spacer(modifier = Modifier.width(16.dp))
                                        
                                        Column {
                                            Text(
                                                text = title,
                                                style = MaterialTheme.typography.bodyLarge,
                                                fontWeight = FontWeight.Medium
                                            )
                                            
                                            Text(
                                                text = description,
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                                            )
                                        }
                                    }
                                    
                                    if (title != "Epsom Salt Bath - 20 minutes") {
                                        Divider(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(vertical = 8.dp)
                                        )
                                    }
                                }
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
                    color = Color(0xFF96854A) // Metallic Gold
                )
            }
        }
    }
}

/**
 * Sleep metric component for displaying individual sleep metrics
 * Provides clear visual representation of sleep data
 */
@Composable
private fun SleepMetric(
    icon: ImageVector,
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            icon,
            contentDescription = label,
            tint = Color(0xFF96854A), // Metallic Gold
            modifier = Modifier.size(28.dp)
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}
