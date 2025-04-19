package com.alkaidynamics.fourscore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkaidynamics.fourscore.data.firebase.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Main ViewModel for the application
 * Manages global state and authentication status
 * Implements accessibility-first approach with clear visual feedback
 */
class MainViewModel : ViewModel() {
    // Services
    private val authService = AuthService()
    
    // Authentication state
    val authState = authService.authState
    
    // Loading state
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // Error state
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    // Initialize ViewModel
    init {
        checkAuthState()
    }
    
    /**
     * Check authentication state
     * Provides clear loading state for accessibility
     */
    private fun checkAuthState() {
        viewModelScope.launch {
            try {
                // Wait for auth state to be determined
                // This will happen automatically through the authState flow
                _isLoading.value = false
            } catch (e: Exception) {
                _error.value = "Error checking authentication: ${e.message}"
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Sign out the current user
     */
    fun signOut() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                authService.signOut()
            } catch (e: Exception) {
                _error.value = "Error signing out: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
