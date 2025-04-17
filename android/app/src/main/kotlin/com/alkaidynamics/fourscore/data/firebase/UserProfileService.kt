package com.alkaidynamics.fourscore.data.firebase

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Service class for managing user profile data in Firestore
 * Implements accessibility-first approach with clear visual feedback and error handling
 */
class UserProfileService {
    private val firestore: FirebaseFirestore = FirebaseConfig.getFirestore()
    private val usersCollection = firestore.collection("users")
    
    // Observable state flows for profile operations
    private val _profileState = MutableStateFlow<ProfileState>(ProfileState.Initial)
    val profileState: StateFlow<ProfileState> = _profileState
    
    /**
     * Create or update a user profile in Firestore
     * @param userId Firebase user ID
     * @param profileData Map of profile data fields
     * @return ProfileResult containing success or error information
     */
    suspend fun createOrUpdateProfile(userId: String, profileData: Map<String, Any>): ProfileResult {
        return try {
            _profileState.value = ProfileState.Loading
            
            // Add timestamp for creation/update
            val dataWithTimestamp = profileData.toMutableMap().apply {
                put("updatedAt", com.google.firebase.Timestamp.now())
            }
            
            // Use merge option to update only provided fields
            usersCollection.document(userId)
                .set(dataWithTimestamp, SetOptions.merge())
                .await()
                
            _profileState.value = ProfileState.Success
            ProfileResult.Success
        } catch (e: Exception) {
            _profileState.value = ProfileState.Error(getErrorMessage(e))
            ProfileResult.Error(getErrorMessage(e))
        }
    }
    
    /**
     * Get user profile data from Firestore
     * @param userId Firebase user ID
     * @return ProfileDataResult containing profile data or error information
     */
    suspend fun getUserProfile(userId: String): ProfileDataResult {
        return try {
            _profileState.value = ProfileState.Loading
            
            val documentSnapshot = usersCollection.document(userId).get().await()
            
            if (documentSnapshot.exists()) {
                val profileData = documentSnapshot.data ?: emptyMap()
                _profileState.value = ProfileState.Success
                ProfileDataResult.Success(profileData)
            } else {
                _profileState.value = ProfileState.NotFound
                ProfileDataResult.NotFound
            }
        } catch (e: Exception) {
            _profileState.value = ProfileState.Error(getErrorMessage(e))
            ProfileDataResult.Error(getErrorMessage(e))
        }
    }
    
    /**
     * Create initial user profile after registration
     * @param user Firebase user object
     * @return ProfileResult containing success or error information
     */
    suspend fun createInitialProfile(user: FirebaseUser): ProfileResult {
        val initialData = mapOf(
            "email" to (user.email ?: ""),
            "displayName" to (user.displayName ?: ""),
            "photoUrl" to (user.photoUrl?.toString() ?: ""),
            "createdAt" to com.google.firebase.Timestamp.now()
        )
        
        return createOrUpdateProfile(user.uid, initialData)
    }
    
    /**
     * Get user-friendly error message from Firestore exceptions
     * Provides clear, accessible error messages for different database operations
     */
    private fun getErrorMessage(exception: Exception): String {
        return when {
            exception.message?.contains("permission") == true -> 
                "You don't have permission to access this profile."
            
            exception.message?.contains("network") == true -> 
                "Network error. Please check your internet connection and try again."
            
            exception.message?.contains("not found") == true -> 
                "Profile not found. Please create a profile first."
            
            else -> "Profile operation failed: ${exception.message}. Please try again."
        }
    }
}

/**
 * Sealed class representing profile operation results
 */
sealed class ProfileResult {
    object Success : ProfileResult()
    data class Error(val message: String) : ProfileResult()
}

/**
 * Sealed class representing profile data retrieval results
 */
sealed class ProfileDataResult {
    data class Success(val data: Map<String, Any>) : ProfileDataResult()
    object NotFound : ProfileDataResult()
    data class Error(val message: String) : ProfileDataResult()
}

/**
 * Sealed class representing profile operation states
 * Used for providing clear visual feedback in the UI
 */
sealed class ProfileState {
    object Initial : ProfileState()
    object Loading : ProfileState()
    object Success : ProfileState()
    object NotFound : ProfileState()
    data class Error(val message: String) : ProfileState()
}
