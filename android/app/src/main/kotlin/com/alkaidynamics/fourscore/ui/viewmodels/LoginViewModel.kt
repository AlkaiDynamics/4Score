package com.alkaidynamics.fourscore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkaidynamics.fourscore.data.firebase.AuthService
import com.alkaidynamics.fourscore.data.firebase.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.util.regex.Pattern

/**
 * ViewModel for the Login screen
 * Implements accessibility-first approach with clear visual feedback and error handling
 */
class LoginViewModel : ViewModel() {
    // Authentication service
    private val authService = AuthService()
    
    // Form state
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()
    
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()
    
    private val _rememberMe = MutableStateFlow(false)
    val rememberMe: StateFlow<Boolean> = _rememberMe.asStateFlow()
    
    // Validation state
    private val _isEmailValid = MutableStateFlow(false)
    val isEmailValid: StateFlow<Boolean> = _isEmailValid.asStateFlow()
    
    private val _isPasswordValid = MutableStateFlow(false)
    val isPasswordValid: StateFlow<Boolean> = _isPasswordValid.asStateFlow()
    
    // Combined validation state
    val canSubmit = combine(_isEmailValid, _isPasswordValid) { emailValid, passwordValid ->
        emailValid && passwordValid
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
     * Update password and validate
     */
    fun updatePassword(newPassword: String) {
        _password.value = newPassword
        _isPasswordValid.value = validatePassword(newPassword)
    }
    
    /**
     * Update remember me state
     */
    fun updateRememberMe(newRememberMe: Boolean) {
        _rememberMe.value = newRememberMe
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
     * Attempt to login with current credentials
     */
    fun login() {
        if (!canSubmit.value) return
        
        viewModelScope.launch {
            authService.loginUser(_email.value, _password.value)
            
            // If remember me is checked, store credentials securely
            // This would typically use encrypted shared preferences or a secure storage solution
            if (_rememberMe.value) {
                // Implementation would go here
                // For security reasons, we're not actually storing credentials in this example
            }
        }
    }
}
