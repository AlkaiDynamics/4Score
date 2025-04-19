package com.alkaidynamics.fourscore.ui.screens.unite

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alkaidynamics.fourscore.ui.components.ChallengeCard
import com.alkaidynamics.fourscore.ui.components.ModuleHeader
import com.alkaidynamics.fourscore.ui.components.SocialPostCard
import com.alkaidynamics.fourscore.ui.viewmodels.UniteViewModel

/**
 * Unite screen component (Social module)
 * Implements accessibility-first approach with clear visual feedback and organization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UniteScreen(
    onBackClick: () -> Unit,
    viewModel: UniteViewModel = viewModel()
) {
    // State
    val isLoading by viewModel.isLoading.collectAsState()
    val posts by viewModel.posts.collectAsState()
    val challenges by viewModel.challenges.collectAsState()
    val selectedTab by viewModel.selectedTab.collectAsState()
    
    // Load social data
    LaunchedEffect(Unit) {
        viewModel.loadSocialData()
    }
    
    // Main content
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Unite - Community") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Open notifications */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                    IconButton(onClick = { /* Open search */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Create new post */ },
                containerColor = MaterialTheme.colorScheme.tertiary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Create Post")
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
                    .padding(horizontal = 16.dp)
            ) {
                // Module header
                ModuleHeader(
                    title = "Unite With Others",
                    subtitle = "Connect, share, and challenge your fitness community",
                    icon = Icons.Default.Group,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                
                // Tab navigation
                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.tertiary
                ) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { viewModel.selectTab(0) },
                        text = { Text("Feed") },
                        icon = { Icon(Icons.Default.DynamicFeed, contentDescription = null) }
                    )
                    
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { viewModel.selectTab(1) },
                        text = { Text("Challenges") },
                        icon = { Icon(Icons.Default.EmojiEvents, contentDescription = null) }
                    )
                    
                    Tab(
                        selected = selectedTab == 2,
                        onClick = { viewModel.selectTab(2) },
                        text = { Text("Friends") },
                        icon = { Icon(Icons.Default.People, contentDescription = null) }
                    )
                }
                
                // Tab content
                when (selectedTab) {
                    // Feed tab
                    0 -> {
                        if (posts.isEmpty() && !isLoading) {
                            EmptyState(
                                icon = Icons.Default.DynamicFeed,
                                title = "No Posts Yet",
                                message = "Be the first to share your fitness journey",
                                buttonText = "Create Post",
                                buttonColor = MaterialTheme.colorScheme.tertiary,
                                onButtonClick = { /* Create post */ }
                            )
                        } else {
                            LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                                contentPadding = PaddingValues(vertical = 16.dp)
                            ) {
                                items(posts) { post ->
                                    SocialPostCard(
                                        userName = post.userName,
                                        userAvatar = post.userAvatar,
                                        timeAgo = post.timeAgo,
                                        content = post.content,
                                        imageUrl = post.imageUrl,
                                        likeCount = post.likeCount,
                                        commentCount = post.commentCount,
                                        isLiked = post.isLiked,
                                        onLikeClick = { viewModel.toggleLike(post.id) },
                                        onCommentClick = { /* Open comments */ },
                                        onShareClick = { /* Share post */ },
                                        modifier = Modifier.padding(bottom = 16.dp)
                                    )
                                }
                            }
                        }
                    }
                    
                    // Challenges tab
                    1 -> {
                        if (challenges.isEmpty() && !isLoading) {
                            EmptyState(
                                icon = Icons.Default.EmojiEvents,
                                title = "No Challenges Yet",
                                message = "Create a challenge to compete with friends",
                                buttonText = "Create Challenge",
                                buttonColor = MaterialTheme.colorScheme.tertiary,
                                onButtonClick = { /* Create challenge */ }
                            )
                        } else {
                            LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                                contentPadding = PaddingValues(vertical = 16.dp)
                            ) {
                                items(challenges) { challenge ->
                                    ChallengeCard(
                                        title = challenge.title,
                                        description = challenge.description,
                                        startDate = challenge.startDate,
                                        endDate = challenge.endDate,
                                        participantCount = challenge.participantCount,
                                        isJoined = challenge.isJoined,
                                        progress = challenge.progress,
                                        onJoinClick = { viewModel.toggleJoinChallenge(challenge.id) },
                                        onViewDetailsClick = { /* View challenge details */ },
                                        modifier = Modifier.padding(bottom = 16.dp)
                                    )
                                }
                            }
                        }
                    }
                    
                    // Friends tab
                    2 -> {
                        EmptyState(
                            icon = Icons.Default.People,
                            title = "Connect with Friends",
                            message = "Find and add friends to share your fitness journey",
                            buttonText = "Find Friends",
                            buttonColor = MaterialTheme.colorScheme.tertiary,
                            onButtonClick = { /* Find friends */ }
                        )
                    }
                }
            }
            
            // Loading indicator
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

/**
 * Empty state component for tabs with no content
 * Provides clear visual feedback and call-to-action
 */
@Composable
private fun EmptyState(
    icon: ImageVector,
    title: String,
    message: String,
    buttonText: String,
    buttonColor: Color,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier.size(64.dp),
                tint = buttonColor.copy(alpha = 0.5f)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Button(
                onClick = onButtonClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                )
            ) {
                Text(buttonText)
            }
        }
    }
}
