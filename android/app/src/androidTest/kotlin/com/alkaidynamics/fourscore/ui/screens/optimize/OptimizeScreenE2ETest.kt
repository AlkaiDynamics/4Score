package com.alkaidynamics.fourscore.ui.screens.optimize

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alkaidynamics.fourscore.data.models.DailyNutrition
import com.alkaidynamics.fourscore.data.models.MealPlan
import com.alkaidynamics.fourscore.ui.MainActivity
import com.alkaidynamics.fourscore.ui.viewmodels.OptimizeViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import java.util.*

/**
 * End-to-End test for the OptimizeScreen
 * Tests the nutrition tracking and display flow from UI perspective
 * Following the one-test-at-a-time approach for systematic testing
 */
@RunWith(AndroidJUnit4::class)
class OptimizeScreenE2ETest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    
    // Mock ViewModel
    private lateinit var mockViewModel: OptimizeViewModel
    
    // Test data
    private val mockDailyNutrition = DailyNutrition(
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
    
    @Before
    fun setUp() {
        // Initialize mock ViewModel
        mockViewModel = mock(OptimizeViewModel::class.java)
        
        // Set up default behavior for StateFlow properties
        `when`(mockViewModel.dailyNutrition).thenReturn(MutableStateFlow(DailyNutrition()))
        `when`(mockViewModel.mealPlan).thenReturn(MutableStateFlow(MealPlan("empty")))
        `when`(mockViewModel.isLoading).thenReturn(MutableStateFlow(false))
        `when`(mockViewModel.error).thenReturn(MutableStateFlow(null))
        
        // Set up the OptimizeScreen with the mock ViewModel
        composeTestRule.setContent {
            OptimizeScreen(
                onBackClick = {},
                viewModel = mockViewModel
            )
        }
    }
    
    /**
     * Test loading nutrition data on screen launch
     * 1. Verify loadNutritionData is called
     * 2. Verify loading indicator is shown when loading
     */
    @Test
    fun optimizeScreen_onLaunch_callsLoadNutritionData() {
        // Verify loadNutritionData is called
        verify(mockViewModel).loadNutritionData()
        
        // Simulate loading state
        `when`(mockViewModel.isLoading).thenReturn(MutableStateFlow(true))
        
        // Verify loading indicator is shown
        composeTestRule.onNodeWithContentDescription("Loading")
            .assertExists()
    }
    
    /**
     * Test displaying nutrition data when data is loaded
     * 1. Set mock nutrition data
     * 2. Verify nutrition summary is displayed
     */
    @Test
    fun optimizeScreen_withNutritionData_displaysNutritionSummary() {
        // Set mock nutrition data
        `when`(mockViewModel.dailyNutrition).thenReturn(MutableStateFlow(mockDailyNutrition))
        `when`(mockViewModel.isLoading).thenReturn(MutableStateFlow(false))
        
        // Verify calories are displayed
        composeTestRule.onNodeWithText("Calories")
            .assertExists()
        
        composeTestRule.onNodeWithText("1450")
            .assertExists()
        
        composeTestRule.onNodeWithText("/ 2200")
            .assertExists()
        
        // Verify macronutrients section is displayed
        composeTestRule.onNodeWithText("MACRONUTRIENTS")
            .assertExists()
        
        composeTestRule.onNodeWithText("Protein")
            .assertExists()
        
        composeTestRule.onNodeWithText("Carbs")
            .assertExists()
        
        composeTestRule.onNodeWithText("Fat")
            .assertExists()
    }
    
    /**
     * Test navigation back functionality
     * 1. Click back button
     * 2. Verify onBackClick is called
     */
    @Test
    fun optimizeScreen_clickBackButton_callsOnBackClick() {
        // Mock the onBackClick callback
        val onBackClick = mock(Function0::class.java)
        
        // Set up the OptimizeScreen with the mock callback
        composeTestRule.setContent {
            OptimizeScreen(
                onBackClick = { onBackClick.invoke() },
                viewModel = mockViewModel
            )
        }
        
        // Click back button
        composeTestRule.onNodeWithContentDescription("Back")
            .performClick()
        
        // Verify onBackClick is called
        verify(onBackClick).invoke()
    }
}
