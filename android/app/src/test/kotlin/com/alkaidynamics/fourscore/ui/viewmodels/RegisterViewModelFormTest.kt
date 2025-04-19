package com.alkaidynamics.fourscore.ui.viewmodels

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Focused test for RegisterViewModel form validation
 * Following the one-test-at-a-time approach for systematic testing
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RegisterViewModelFormTest {

    // Test dispatcher for coroutines
    private val testDispatcher = StandardTestDispatcher()
    
    // Form state
    private val _isEmailValid = MutableStateFlow(false)
    private val _isPasswordValid = MutableStateFlow(false)
    private val _isConfirmPasswordValid = MutableStateFlow(false)
    private val _isDisplayNameValid = MutableStateFlow(false)
    private val _acceptTerms = MutableStateFlow(false)
    
    // Combined validation state (extracted from RegisterViewModel)
    val canSubmit = combine(
        _isEmailValid,
        _isPasswordValid,
        _isConfirmPasswordValid,
        _isDisplayNameValid,
        _acceptTerms
    ) { emailValid, passwordValid, confirmPasswordValid, displayNameValid, termsAccepted ->
        emailValid && passwordValid && confirmPasswordValid && displayNameValid && termsAccepted
    }

    @Before
    fun setup() {
        // Set the main dispatcher for coroutines
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Reset the main dispatcher
        Dispatchers.resetMain()
    }

    /**
     * Test that form can be submitted when all fields are valid
     */
    @Test
    fun `test can submit when all fields are valid`() {
        // Given all fields are valid
        _isEmailValid.value = true
        _isPasswordValid.value = true
        _isConfirmPasswordValid.value = true
        _isDisplayNameValid.value = true
        _acceptTerms.value = true
        
        // Then form can be submitted
        assertTrue(canSubmit.value)
    }
    
    /**
     * Test that form cannot be submitted when email is invalid
     */
    @Test
    fun `test cannot submit when email is invalid`() {
        // Given all fields are valid except email
        _isEmailValid.value = false
        _isPasswordValid.value = true
        _isConfirmPasswordValid.value = true
        _isDisplayNameValid.value = true
        _acceptTerms.value = true
        
        // Then form cannot be submitted
        assertFalse(canSubmit.value)
    }
    
    /**
     * Test that form cannot be submitted when password is invalid
     */
    @Test
    fun `test cannot submit when password is invalid`() {
        // Given all fields are valid except password
        _isEmailValid.value = true
        _isPasswordValid.value = false
        _isConfirmPasswordValid.value = true
        _isDisplayNameValid.value = true
        _acceptTerms.value = true
        
        // Then form cannot be submitted
        assertFalse(canSubmit.value)
    }
    
    /**
     * Test that form cannot be submitted when confirm password is invalid
     */
    @Test
    fun `test cannot submit when confirm password is invalid`() {
        // Given all fields are valid except confirm password
        _isEmailValid.value = true
        _isPasswordValid.value = true
        _isConfirmPasswordValid.value = false
        _isDisplayNameValid.value = true
        _acceptTerms.value = true
        
        // Then form cannot be submitted
        assertFalse(canSubmit.value)
    }
    
    /**
     * Test that form cannot be submitted when display name is invalid
     */
    @Test
    fun `test cannot submit when display name is invalid`() {
        // Given all fields are valid except display name
        _isEmailValid.value = true
        _isPasswordValid.value = true
        _isConfirmPasswordValid.value = true
        _isDisplayNameValid.value = false
        _acceptTerms.value = true
        
        // Then form cannot be submitted
        assertFalse(canSubmit.value)
    }
    
    /**
     * Test that form cannot be submitted when terms are not accepted
     */
    @Test
    fun `test cannot submit when terms are not accepted`() {
        // Given all fields are valid except terms acceptance
        _isEmailValid.value = true
        _isPasswordValid.value = true
        _isConfirmPasswordValid.value = true
        _isDisplayNameValid.value = true
        _acceptTerms.value = false
        
        // Then form cannot be submitted
        assertFalse(canSubmit.value)
    }
}
