package com.alkaidynamics.fourscore.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkaidynamics.fourscore.data.firebase.AuthService
import com.alkaidynamics.fourscore.data.firebase.UserProfileService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Home screen
 * Implements accessibility-first approach with clear visual feedback and error handling
 */
class HomeViewModel : ViewModel() {
    // Services
    private val authService = AuthService()
    private val userProfileService = UserProfileService()
    
    // User data
    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName.asStateFlow()
    
    // Loading state
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // Error state
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    /**
     * Load user data from Firestore
     * Provides clear loading state for accessibility
     */
    fun loadUserData() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            try {
                // Get current user ID
                val currentUser = authService.currentUser.value
                
                if (currentUser != null) {
                    // Fetch user profile
                    val result = userProfileService.getUserProfile(currentUser.uid)
                    
                    when (result) {
                        is com.alkaidynamics.fourscore.data.firebase.ProfileDataResult.Success -> {
                            // Extract user name from profile data
                            val displayName = result.data["displayName"] as? String ?: ""
                            _userName.value = displayName
                        }
                        
                        is com.alkaidynamics.fourscore.data.firebase.ProfileDataResult.NotFound -> {
                            // No profile found, use email as fallback
                            _userName.value = currentUser.email?.substringBefore('@') ?: ""
                        }
                        
                        is com.alkaidynamics.fourscore.data.firebase.ProfileDataResult.Error -> {
                            _error.value = result.message
                            // Use email as fallback
                            _userName.value = currentUser.email?.substringBefore('@') ?: ""
                        }
                    }
                } else {
                    // No user logged in
                    _userName.value = ""
                    _error.value = "No user logged in"
                }
            } catch (e: Exception) {
                _error.value = "Error loading user data: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Sign out the current user
     */
    fun signOut() {
        authService.signOut()
    }
}
