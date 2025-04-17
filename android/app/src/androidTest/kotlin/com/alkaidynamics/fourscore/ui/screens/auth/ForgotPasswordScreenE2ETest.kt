package com.alkaidynamics.fourscore.ui.screens.auth

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alkaidynamics.fourscore.data.firebase.AuthState
import com.alkaidynamics.fourscore.ui.MainActivity
import com.alkaidynamics.fourscore.ui.viewmodels.ForgotPasswordViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*

/**
 * End-to-End test for the ForgotPasswordScreen
 * Tests the password reset flow from UI perspective
 * Following the one-test-at-a-time approach for systematic testing
 */
@RunWith(AndroidJUnit4::class)
class ForgotPasswordScreenE2ETest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    
    // Mock ViewModel
    private lateinit var mockViewModel: ForgotPasswordViewModel
    
    // Test data
    private val validEmail = "user@example.com"
    
    @Before
    fun setUp() {
        // Initialize mock ViewModel
        mockViewModel = mock(ForgotPasswordViewModel::class.java)
        
        // Set up default behavior for StateFlow properties
        `when`(mockViewModel.email).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(""))
        `when`(mockViewModel.isEmailValid).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(false))
        `when`(mockViewModel.canSubmit).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(false))
        `when`(mockViewModel.authState).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(AuthState.Unauthenticated))
        
        // Set up the ForgotPasswordScreen with the mock ViewModel
        composeTestRule.setContent {
            ForgotPasswordScreen(
                onBackToLoginClick = {},
                viewModel = mockViewModel
            )
        }
    }
    
    /**
     * Test successful password reset flow
     * 1. Enter valid email
     * 2. Click reset button
     * 3. Verify resetPassword method is called
     */
    @Test
    fun forgotPasswordScreen_validEmail_callsResetPasswordMethod() {
        // Enter valid email
        composeTestRule.onNodeWithText("Email")
            .performTextInput(validEmail)
        verify(mockViewModel).updateEmail(validEmail)
        
        // Enable the reset button
        `when`(mockViewModel.canSubmit).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(true))
        `when`(mockViewModel.authState).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(AuthState.Unauthenticated))
        
        // Click reset button
        composeTestRule.onNodeWithText("Send Reset Instructions")
            .performClick()
        
        // Verify resetPassword method is called
        verify(mockViewModel).resetPassword()
    }
    
    /**
     * Test back to login navigation
     * 1. Click back button
     * 2. Verify onBackToLoginClick is called
     */
    @Test
    fun forgotPasswordScreen_clickBackButton_callsOnBackToLoginClick() {
        // Mock the onBackToLoginClick callback
        val onBackToLoginClick = mock(Function0::class.java)
        
        // Set up the ForgotPasswordScreen with the mock callback
        composeTestRule.setContent {
            ForgotPasswordScreen(
                onBackToLoginClick = { onBackToLoginClick.invoke() },
                viewModel = mockViewModel
            )
        }
        
        // Click back button
        composeTestRule.onNodeWithContentDescription("Back to Login")
            .performClick()
        
        // Verify onBackToLoginClick is called
        verify(onBackToLoginClick).invoke()
    }
}
