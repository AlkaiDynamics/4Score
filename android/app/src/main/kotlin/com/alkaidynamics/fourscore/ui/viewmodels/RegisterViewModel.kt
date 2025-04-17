package com.alkaidynamics.fourscore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkaidynamics.fourscore.data.firebase.AuthService
import com.alkaidynamics.fourscore.data.firebase.AuthState
import com.alkaidynamics.fourscore.data.firebase.UserProfileService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.util.regex.Pattern

/**
 * Enum representing password strength levels
 */
enum class PasswordStrength {
    WEAK,
    MEDIUM,
    STRONG,
    VERY_STRONG
}

/**
 * ViewModel for the Register screen
 * Implements accessibility-first approach with clear visual feedback and error handling
 */
class RegisterViewModel : ViewModel() {
    // Services
    private val authService = AuthService()
    private val userProfileService = UserProfileService()
    
    // Form state
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()
    
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()
    
    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword.asStateFlow()
    
    private val _displayName = MutableStateFlow("")
    val displayName: StateFlow<String> = _displayName.asStateFlow()
    
    private val _acceptTerms = MutableStateFlow(false)
    val acceptTerms: StateFlow<Boolean> = _acceptTerms.asStateFlow()
    
    // Validation state
    private val _isEmailValid = MutableStateFlow(false)
    val isEmailValid: StateFlow<Boolean> = _isEmailValid.asStateFlow()
    
    private val _isPasswordValid = MutableStateFlow(false)
    val isPasswordValid: StateFlow<Boolean> = _isPasswordValid.asStateFlow()
    
    private val _isConfirmPasswordValid = MutableStateFlow(false)
    val isConfirmPasswordValid: StateFlow<Boolean> = _isConfirmPasswordValid.asStateFlow()
    
    private val _isDisplayNameValid = MutableStateFlow(false)
    val isDisplayNameValid: StateFlow<Boolean> = _isDisplayNameValid.asStateFlow()
    
    // Password strength
    private val _passwordStrength = MutableStateFlow(PasswordStrength.WEAK)
    val passwordStrength: StateFlow<PasswordStrength> = _passwordStrength.asStateFlow()
    
    // Combined validation state
    val canSubmit = combine(
        _isEmailValid,
        _isPasswordValid,
        _isConfirmPasswordValid,
        _isDisplayNameValid,
        _acceptTerms
    ) { emailValid, passwordValid, confirmPasswordValid, displayNameValid, termsAccepted ->
        emailValid && passwordValid && confirmPasswordValid && displayNameValid && termsAccepted
    }
    
    // Authentication state
    val authState: StateFlow<AuthState> = authService.authState
    
    // Email validation pattern
    private val emailPattern = Pattern.compile(
        "[a-zA-Z0-9+._%\\-]{1,256}" +
        "@" +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
        "(" +
        "\\." +
        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
        ")+"
    )
    
    /**
     * Update email and validate
     */
    fun updateEmail(newEmail: String) {
        _email.value = newEmail
        _isEmailValid.value = validateEmail(newEmail)
    }
    
    /**
     * Update password, validate, and calculate strength
     */
    fun updatePassword(newPassword: String) {
        _password.value = newPassword
        _isPasswordValid.value = validatePassword(newPassword)
        _passwordStrength.value = calculatePasswordStrength(newPassword)
        
        // Also validate confirm password when password changes
        if (_confirmPassword.value.isNotEmpty()) {
            _isConfirmPasswordValid.value = validateConfirmPassword(_confirmPassword.value, newPassword)
        }
    }
    
    /**
     * Update confirm password and validate
     */
    fun updateConfirmPassword(newConfirmPassword: String) {
        _confirmPassword.value = newConfirmPassword
        _isConfirmPasswordValid.value = validateConfirmPassword(newConfirmPassword, _password.value)
    }
    
    /**
     * Update display name and validate
     */
    fun updateDisplayName(newDisplayName: String) {
        _displayName.value = newDisplayName
        _isDisplayNameValid.value = validateDisplayName(newDisplayName)
    }
    
    /**
     * Update terms acceptance
     */
    fun updateAcceptTerms(accepted: Boolean) {
        _acceptTerms.value = accepted
    }
    
    /**
     * Validate email format
     */
    private fun validateEmail(email: String): Boolean {
        return email.isNotEmpty() && emailPattern.matcher(email).matches()
    }
    
    /**
     * Validate password requirements
     * Currently just checks for minimum length
     */
    private fun validatePassword(password: String): Boolean {
        return password.length >= 8
    }
    
    /**
     * Validate confirm password matches password
     */
    private fun validateConfirmPassword(confirmPassword: String, password: String): Boolean {
        return confirmPassword.isNotEmpty() && confirmPassword == password
    }
    
    /**
     * Validate display name requirements
     */
    private fun validateDisplayName(displayName: String): Boolean {
        return displayName.length >= 3
    }
    
    /**
     * Calculate password strength based on complexity
     */
    private fun calculatePasswordStrength(password: String): PasswordStrength {
        if (password.isEmpty()) return PasswordStrength.WEAK
        
        var score = 0
        
        // Length check
        if (password.length >= 8) score++
        if (password.length >= 12) score++
        
        // Character variety checks
        if (password.any { it.isDigit() }) score++
        if (password.any { it.isLowerCase() }) score++
        if (password.any { it.isUpperCase() }) score++
        if (password.any { !it.isLetterOrDigit() }) score++
        
        return when {
            score <= 2 -> PasswordStrength.WEAK
            score <= 4 -> PasswordStrength.MEDIUM
            score <= 6 -> PasswordStrength.STRONG
            else -> PasswordStrength.VERY_STRONG
        }
    }
    
    /**
     * Attempt to register with current form data
     */
    fun register() {
        if (!canSubmit.value) return
        
        viewModelScope.launch {
            val result = authService.registerUser(_email.value, _password.value)
            
            // If registration successful, create user profile
            if (result is com.alkaidynamics.fourscore.data.firebase.AuthResult.Success && result.user != null) {
                val user = result.user
                
                // Create initial profile with display name
                val profileData = mapOf(
                    "displayName" to _displayName.value,
                    "email" to _email.value
                )
                
                userProfileService.createOrUpdateProfile(user.uid, profileData)
            }
        }
    }
}
