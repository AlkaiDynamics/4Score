package com.alkaidynamics.fourscore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkaidynamics.fourscore.data.firebase.AuthService
import com.alkaidynamics.fourscore.data.firebase.AuthState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.regex.Pattern

/**
 * ViewModel for the Forgot Password screen
 * Implements accessibility-first approach with clear visual feedback and error handling
 */
class ForgotPasswordViewModel : ViewModel() {
    // Authentication service
    private val authService = AuthService()
    
    // Form state
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()
    
    // Validation state
    private val _isEmailValid = MutableStateFlow(false)
    val isEmailValid: StateFlow<Boolean> = _isEmailValid.asStateFlow()
    
    // Combined validation state
    val canSubmit: StateFlow<Boolean> = _isEmailValid
    
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
     * Validate email format
     */
    private fun validateEmail(email: String): Boolean {
        return email.isNotEmpty() && emailPattern.matcher(email).matches()
    }
    
    /**
     * Send password reset email
     */
    fun resetPassword() {
        if (!canSubmit.value) return
        
        viewModelScope.launch {
            authService.resetPassword(_email.value)
        }
    }
}
