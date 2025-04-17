package com.alkaidynamics.fourscore.ui.screens.auth

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alkaidynamics.fourscore.data.firebase.AuthState
import com.alkaidynamics.fourscore.ui.MainActivity
import com.alkaidynamics.fourscore.ui.viewmodels.RegisterViewModel
import com.alkaidynamics.fourscore.ui.viewmodels.PasswordStrength
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*

/**
 * End-to-End test for the RegisterScreen
 * Tests the core registration flow from UI perspective
 * Following the one-test-at-a-time approach for systematic testing
 */
@RunWith(AndroidJUnit4::class)
class RegisterScreenE2ETest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    
    // Mock ViewModel
    private lateinit var mockViewModel: RegisterViewModel
    
    // Test data
    private val validEmail = "newuser@example.com"
    private val validPassword = "StrongP@ss123"
    private val validDisplayName = "John Doe"
    
    @Before
    fun setUp() {
        // Initialize mock ViewModel
        mockViewModel = mock(RegisterViewModel::class.java)
        
        // Set up default behavior for StateFlow properties
        `when`(mockViewModel.email).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(""))
        `when`(mockViewModel.password).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(""))
        `when`(mockViewModel.confirmPassword).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(""))
        `when`(mockViewModel.displayName).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(""))
        `when`(mockViewModel.acceptTerms).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(false))
        `when`(mockViewModel.isEmailValid).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(false))
        `when`(mockViewModel.isPasswordValid).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(false))
        `when`(mockViewModel.isConfirmPasswordValid).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(false))
        `when`(mockViewModel.isDisplayNameValid).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(false))
        `when`(mockViewModel.passwordStrength).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(PasswordStrength.WEAK))
        `when`(mockViewModel.canSubmit).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(false))
        `when`(mockViewModel.authState).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(AuthState.Unauthenticated))
        
        // Set up the RegisterScreen with the mock ViewModel
        composeTestRule.setContent {
            RegisterScreen(
                onRegisterSuccess = {},
                onLoginClick = {},
                viewModel = mockViewModel
            )
        }
    }
    
    /**
     * Test successful registration flow
     * 1. Enter valid display name
     * 2. Enter valid email
     * 3. Enter valid password
     * 4. Enter matching confirm password
     * 5. Accept terms and conditions
     * 6. Click register button
     * 7. Verify register method is called
     */
    @Test
    fun registerScreen_validInputs_callsRegisterMethod() {
        // Enter valid display name
        composeTestRule.onNodeWithText("Full Name")
            .performTextInput(validDisplayName)
        verify(mockViewModel).updateDisplayName(validDisplayName)
        
        // Enter valid email
        composeTestRule.onNodeWithText("Email")
            .performTextInput(validEmail)
        verify(mockViewModel).updateEmail(validEmail)
        
        // Enter valid password
        composeTestRule.onNodeWithText("Password")
            .performTextInput(validPassword)
        verify(mockViewModel).updatePassword(validPassword)
        
        // Enter matching confirm password
        composeTestRule.onNodeWithText("Confirm Password")
            .performTextInput(validPassword)
        verify(mockViewModel).updateConfirmPassword(validPassword)
        
        // Accept terms and conditions
        composeTestRule.onNodeWithText("I accept the Terms & Conditions")
            .performClick()
        verify(mockViewModel).updateAcceptTerms(true)
        
        // Enable the register button
        `when`(mockViewModel.canSubmit).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(true))
        `when`(mockViewModel.authState).thenReturn(kotlinx.coroutines.flow.MutableStateFlow(AuthState.Unauthenticated))
        
        // Click register button
        composeTestRule.onNodeWithText("Create Account")
            .performClick()
        
        // Verify register method is called
        verify(mockViewModel).register()
    }
}
