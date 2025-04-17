package com.alkaidynamics.fourscore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkaidynamics.fourscore.data.models.Challenge
import com.alkaidynamics.fourscore.data.models.ChallengeType
import com.alkaidynamics.fourscore.data.models.SocialPost
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

/**
 * ViewModel for the Unite module (Social)
 * Implements accessibility-first approach with clear loading states and error handling
 */
class UniteViewModel : ViewModel() {
    // Social data
    private val _posts = MutableStateFlow<List<SocialPost>>(emptyList())
    val posts: StateFlow<List<SocialPost>> = _posts.asStateFlow()
    
    private val _challenges = MutableStateFlow<List<Challenge>>(emptyList())
    val challenges: StateFlow<List<Challenge>> = _challenges.asStateFlow()
    
    // Tab selection
    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()
    
    // Loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // Error state
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    /**
     * Load social data from Firestore
     * Currently uses mock data for demonstration
     */
    fun loadSocialData() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            try {
                // Simulate network delay
                delay(1500)
                
                // Mock data - will be replaced with Firestore data
                val mockPosts = createMockPosts()
                _posts.value = mockPosts
                
                val mockChallenges = createMockChallenges()
                _challenges.value = mockChallenges
            } catch (e: Exception) {
                _error.value = "Error loading social data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Select a tab
     */
    fun selectTab(index: Int) {
        _selectedTab.value = index
    }
    
    /**
     * Toggle like on a post
     */
    fun toggleLike(postId: String) {
        val updatedPosts = _posts.value.map { post ->
            if (post.id == postId) {
                val newLikeCount = if (post.isLiked) post.likeCount - 1 else post.likeCount + 1
                post.copy(
                    isLiked = !post.isLiked,
                    likeCount = newLikeCount
                )
            } else {
                post
            }
        }
        
        _posts.value = updatedPosts
    }
    
    /**
     * Toggle join/leave a challenge
     */
    fun toggleJoinChallenge(challengeId: String) {
        val updatedChallenges = _challenges.value.map { challenge ->
            if (challenge.id == challengeId) {
                val newParticipantCount = if (challenge.isJoined) 
                    challenge.participantCount - 1 
                else 
                    challenge.participantCount + 1
                
                challenge.copy(
                    isJoined = !challenge.isJoined,
                    participantCount = newParticipantCount
                )
            } else {
                challenge
            }
        }
        
        _challenges.value = updatedChallenges
    }
    
    /**
     * Create mock posts data for demonstration
     * Will be replaced with actual Firestore data
     */
    private fun createMockPosts(): List<SocialPost> {
        return listOf(
            SocialPost(
                id = "post1",
                userId = "user1",
                userName = "John Fitness",
                userAvatar = null,
                content = "Just completed a 5-mile run! Feeling great and ready to take on the day. #MorningWorkout #Running",
                likeCount = 15,
                commentCount = 3,
                isLiked = true,
                timeAgo = "2 hours ago"
            ),
            SocialPost(
                id = "post2",
                userId = "user2",
                userName = "Sarah Strong",
                userAvatar = null,
                content = "New personal record on bench press today! 135lbs x 5 reps. Hard work is paying off! 💪 #Strength #PersonalRecord",
                imageUrl = null,
                likeCount = 24,
                commentCount = 7,
                isLiked = false,
                timeAgo = "5 hours ago"
            ),
            SocialPost(
                id = "post3",
                userId = "user3",
                userName = "Mike Health",
                userAvatar = null,
                content = "Meal prep Sunday! Prepared all my lunches for the week. Healthy eating is the foundation of fitness. #MealPrep #HealthyEating",
                imageUrl = null,
                likeCount = 18,
                commentCount = 4,
                isLiked = false,
                timeAgo = "1 day ago"
            )
        )
    }
    
    /**
     * Create mock challenges data for demonstration
     * Will be replaced with actual Firestore data
     */
    private fun createMockChallenges(): List<Challenge> {
        val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.US)
        val calendar = Calendar.getInstance()
        
        // Start date (today)
        val startDate = calendar.time
        
        // End date (30 days from now)
        calendar.add(Calendar.DAY_OF_MONTH, 30)
        val endDate = calendar.time
        
        return listOf(
            Challenge(
                id = "challenge1",
                title = "30-Day Running Challenge",
                description = "Run at least 2 miles every day for 30 days. Track your progress and share your journey!",
                startDate = dateFormat.format(startDate),
                endDate = dateFormat.format(endDate),
                startDateObj = startDate,
                endDateObj = endDate,
                creatorId = "user1",
                creatorName = "John Fitness",
                participantCount = 24,
                isJoined = true,
                progress = 0.2f,
                goal = 60,
                goalUnit = "miles",
                type = ChallengeType.DISTANCE
            ),
            Challenge(
                id = "challenge2",
                title = "Summer Strength Challenge",
                description = "Complete 20 strength workouts in 30 days. Build muscle and improve your overall strength!",
                startDate = dateFormat.format(startDate),
                endDate = dateFormat.format(endDate),
                startDateObj = startDate,
                endDateObj = endDate,
                creatorId = "user2",
                creatorName = "Sarah Strong",
                participantCount = 18,
                isJoined = false,
                progress = 0f,
                goal = 20,
                goalUnit = "workouts",
                type = ChallengeType.WORKOUTS
            ),
            Challenge(
                id = "challenge3",
                title = "10,000 Steps Daily",
                description = "Walk at least 10,000 steps every day for 30 days. Great for beginners and active recovery!",
                startDate = dateFormat.format(startDate),
                endDate = dateFormat.format(endDate),
                startDateObj = startDate,
                endDateObj = endDate,
                creatorId = "user3",
                creatorName = "Mike Health",
                participantCount = 42,
                isJoined = false,
                progress = 0f,
                goal = 300000,
                goalUnit = "steps",
                type = ChallengeType.STEPS
            )
        )
    }
}
