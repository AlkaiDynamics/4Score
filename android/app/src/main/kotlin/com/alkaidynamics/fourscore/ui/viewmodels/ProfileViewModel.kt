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
 * ViewModel for the Profile screen
 * Implements accessibility-first approach with clear visual feedback and error handling
 */
class ProfileViewModel : ViewModel() {
    // Services
    private val authService = AuthService()
    private val userProfileService = UserProfileService()
    
    // Profile data
    private val _displayName = MutableStateFlow("")
    val displayName: StateFlow<String> = _displayName.asStateFlow()
    
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()
    
    private val _photoUrl = MutableStateFlow<String?>(null)
    val photoUrl: StateFlow<String?> = _photoUrl.asStateFlow()
    
    private val _height = MutableStateFlow<String?>(null)
    val height: StateFlow<String?> = _height.asStateFlow()
    
    private val _weight = MutableStateFlow<String?>(null)
    val weight: StateFlow<String?> = _weight.asStateFlow()
    
    private val _fitnessGoal = MutableStateFlow<String?>(null)
    val fitnessGoal: StateFlow<String?> = _fitnessGoal.asStateFlow()
    
    // Form validation
    private val _isDisplayNameValid = MutableStateFlow(true)
    val isDisplayNameValid: StateFlow<Boolean> = _isDisplayNameValid.asStateFlow()
    
    private val _isHeightValid = MutableStateFlow(true)
    val isHeightValid: StateFlow<Boolean> = _isHeightValid.asStateFlow()
    
    private val _isWeightValid = MutableStateFlow(true)
    val isWeightValid: StateFlow<Boolean> = _isWeightValid.asStateFlow()
    
    // Profile state
    val profileState = userProfileService.profileState
    
    // Loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    // Error state
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    /**
     * Load user profile data from Firestore
     * Provides clear loading state for accessibility
     */
    fun loadUserProfile() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            try {
                // Get current user ID
                val currentUser = authService.currentUser.value
                
                if (currentUser != null) {
                    // Set email from auth user
                    _email.value = currentUser.email ?: ""
                    
                    // Fetch user profile
                    val result = userProfileService.getUserProfile(currentUser.uid)
                    
                    when (result) {
                        is com.alkaidynamics.fourscore.data.firebase.ProfileDataResult.Success -> {
                            // Extract profile data
                            val profileData = result.data
                            _displayName.value = profileData["displayName"] as? String ?: ""
                            _photoUrl.value = profileData["photoUrl"] as? String
                            _height.value = profileData["height"] as? String
                            _weight.value = profileData["weight"] as? String
                            _fitnessGoal.value = profileData["fitnessGoal"] as? String
                        }
                        
                        is com.alkaidynamics.fourscore.data.firebase.ProfileDataResult.NotFound -> {
                            // No profile found, use email as display name
                            _displayName.value = currentUser.displayName ?: currentUser.email?.substringBefore('@') ?: ""
                        }
                        
                        is com.alkaidynamics.fourscore.data.firebase.ProfileDataResult.Error -> {
                            _error.value = result.message
                        }
                    }
                } else {
                    // No user logged in
                    _error.value = "No user logged in"
                }
            } catch (e: Exception) {
                _error.value = "Error loading profile: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Update display name
     */
    fun updateDisplayName(newDisplayName: String) {
        _displayName.value = newDisplayName
        _isDisplayNameValid.value = validateDisplayName(newDisplayName)
    }
    
    /**
     * Update height
     */
    fun updateHeight(newHeight: String) {
        _height.value = newHeight
        _isHeightValid.value = validateHeight(newHeight)
    }
    
    /**
     * Update weight
     */
    fun updateWeight(newWeight: String) {
        _weight.value = newWeight
        _isWeightValid.value = validateWeight(newWeight)
    }
    
    /**
     * Update fitness goal
     */
    fun updateFitnessGoal(newFitnessGoal: String) {
        _fitnessGoal.value = newFitnessGoal
    }
    
    /**
     * Save profile changes to Firestore
     * Provides clear loading and error states for accessibility
     */
    fun saveProfile() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            try {
                // Validate all fields
                if (!_isDisplayNameValid.value || !_isHeightValid.value || !_isWeightValid.value) {
                    _error.value = "Please fix the errors in the form"
                    _isLoading.value = false
                    return@launch
                }
                
                // Get current user ID
                val currentUser = authService.currentUser.value
                
                if (currentUser != null) {
                    // Create profile data map
                    val profileData = mutableMapOf<String, Any>(
                        "displayName" to _displayName.value,
                        "email" to _email.value
                    )
                    
                    // Add optional fields if present
                    _photoUrl.value?.let { profileData["photoUrl"] = it }
                    _height.value?.let { profileData["height"] = it }
                    _weight.value?.let { profileData["weight"] = it }
                    _fitnessGoal.value?.let { profileData["fitnessGoal"] = it }
                    
                    // Save profile
                    val result = userProfileService.createOrUpdateProfile(currentUser.uid, profileData)
                    
                    if (result is com.alkaidynamics.fourscore.data.firebase.ProfileResult.Error) {
                        _error.value = result.message
                    }
                } else {
                    // No user logged in
                    _error.value = "No user logged in"
                }
            } catch (e: Exception) {
                _error.value = "Error saving profile: ${e.message}"
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
    
    /**
     * Validate display name
     */
    private fun validateDisplayName(displayName: String): Boolean {
        return displayName.length >= 3
    }
    
    /**
     * Validate height
     */
    private fun validateHeight(height: String): Boolean {
        if (height.isEmpty()) return true // Optional field
        return try {
            val heightValue = height.toFloat()
            heightValue > 0
        } catch (e: Exception) {
            false
        }
    }
    
    /**
     * Validate weight
     */
    private fun validateWeight(weight: String): Boolean {
        if (weight.isEmpty()) return true // Optional field
        return try {
            val weightValue = weight.toFloat()
            weightValue > 0
        } catch (e: Exception) {
            false
        }
    }
}
