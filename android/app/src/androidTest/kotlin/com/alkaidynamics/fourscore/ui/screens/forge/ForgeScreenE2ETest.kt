package com.alkaidynamics.fourscore.ui.screens.forge

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alkaidynamics.fourscore.data.models.Exercise
import com.alkaidynamics.fourscore.data.models.Workout
import com.alkaidynamics.fourscore.ui.MainActivity
import com.alkaidynamics.fourscore.ui.viewmodels.ForgeViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*

/**
 * End-to-End test for the ForgeScreen
 * Tests the workout display and interaction flow from UI perspective
 * Following the one-test-at-a-time approach for systematic testing
 */
@RunWith(AndroidJUnit4::class)
class ForgeScreenE2ETest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    
    // Mock ViewModel
    private lateinit var mockViewModel: ForgeViewModel
    
    // Test data
    private val mockWorkouts = listOf(
        Workout(
            id = "test-workout-1",
            name = "Test Workout 1",
            description = "Test workout description",
            exercises = listOf(
                Exercise(
                    id = "test-exercise-1",
                    name = "Test Exercise 1",
                    muscleGroup = "Test Group",
                    equipment = "Test Equipment",
                    instructions = "Test instructions"
                )
            ),
            estimatedDuration = 30
        )
    )
    
    @Before
    fun setUp() {
        // Initialize mock ViewModel
        mockViewModel = mock(ForgeViewModel::class.java)
        
        // Set up default behavior for StateFlow properties
        `when`(mockViewModel.workouts).thenReturn(MutableStateFlow(emptyList()))
        `when`(mockViewModel.isLoading).thenReturn(MutableStateFlow(false))
        `when`(mockViewModel.error).thenReturn(MutableStateFlow(null))
        
        // Set up the ForgeScreen with the mock ViewModel
        composeTestRule.setContent {
            ForgeScreen(
                onBackClick = {},
                viewModel = mockViewModel
            )
        }
    }
    
    /**
     * Test loading workouts on screen launch
     * 1. Verify loadWorkouts is called
     * 2. Verify loading indicator is shown when loading
     */
    @Test
    fun forgeScreen_onLaunch_callsLoadWorkouts() {
        // Verify loadWorkouts is called
        verify(mockViewModel).loadWorkouts()
        
        // Simulate loading state
        `when`(mockViewModel.isLoading).thenReturn(MutableStateFlow(true))
        
        // Verify loading indicator is shown
        composeTestRule.onNodeWithContentDescription("Loading")
            .assertExists()
    }
    
    /**
     * Test displaying workouts when data is loaded
     * 1. Set mock workouts data
     * 2. Verify workout cards are displayed
     */
    @Test
    fun forgeScreen_withWorkouts_displaysWorkoutCards() {
        // Set mock workouts data
        `when`(mockViewModel.workouts).thenReturn(MutableStateFlow(mockWorkouts))
        `when`(mockViewModel.isLoading).thenReturn(MutableStateFlow(false))
        
        // Verify workout card is displayed
        composeTestRule.onNodeWithText("Test Workout 1")
            .assertExists()
        
        composeTestRule.onNodeWithText("Test workout description")
            .assertExists()
    }
    
    /**
     * Test empty state when no workouts are available
     * 1. Set empty workouts data
     * 2. Verify empty state message is displayed
     */
    @Test
    fun forgeScreen_withNoWorkouts_displaysEmptyState() {
        // Set empty workouts data
        `when`(mockViewModel.workouts).thenReturn(MutableStateFlow(emptyList()))
        `when`(mockViewModel.isLoading).thenReturn(MutableStateFlow(false))
        
        // Verify empty state message is displayed
        composeTestRule.onNodeWithText("No Routines Found")
            .assertExists()
    }
}
