package com.alkaidynamics.fourscore.ui.screens.auth

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alkaidynamics.fourscore.data.firebase.AuthState
import com.alkaidynamics.fourscore.ui.MainActivity
import com.alkaidynamics.fourscore.ui.viewmodels.LoginViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*

/**
 * End-to-End test for the LoginScreen
 * Tests the core login flow from UI perspective
 * Following the one-test-at-a-time approach for systematic testing
 */
@RunWith(AndroidJUnit4::class)
class LoginScreenE2ETest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    
    // Mock ViewModel
    private lateinit var mockViewModel: LoginViewModel
    
    // Test data
    private val validEmail = "user@example.com"
    private val validPassword = "Password123"
    
    @Before
    fun setUp() {
        // Initialize mock ViewModel
        mockViewModel = mock(LoginViewModel::class.java)
        
        // Set up the LoginScreen with the mock ViewModel
        composeTestRule.setContent {
            LoginScreen(
                onLoginSuccess = {},
                onRegisterClick = {},
                onForgotPasswordClick = {},
                viewModel = mockViewModel
            )
        }
    }
    
    /**
     * Test successful login flow
     * 1. Enter valid email and password
     * 2. Click login button
     * 3. Verify login method is called
     */
    @Test
    fun loginScreen_validCredentials_callsLoginMethod() {
        // Enter valid email
        composeTestRule.onNodeWithText("Email")
            .performTextInput(validEmail)
        
        // Enter valid password
        composeTestRule.onNodeWithText("Password")
            .performTextInput(validPassword)
        
        // Enable the login button
        `when`(mockViewModel.canSubmit).thenReturn(true)
        `when`(mockViewModel.authState).thenReturn(AuthState.Unauthenticated)
        
        // Click login button
        composeTestRule.onNodeWithText("Sign In")
            .performClick()
        
        // Verify login method is called
        verify(mockViewModel).login()
    }
}
