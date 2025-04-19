package com.alkaidynamics.fourscore.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Service class for handling Firebase Authentication operations
 * Implements accessibility-first approach with clear visual feedback and error handling
 */
class AuthService(
    // Dependency injection for testability
    private val auth: FirebaseAuth = FirebaseConfig.getAuth()
) {
    // Observable state flows for authentication state
    private val _currentUser = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val currentUser: StateFlow<FirebaseUser?> = _currentUser
    
    private val _authState = MutableStateFlow(
        if (auth.currentUser != null) AuthState(true, auth.currentUser)
        else AuthState(false, null)
    )
    val authState: StateFlow<AuthState> = _authState
    
    init {
        // Listen for authentication state changes
        auth.addAuthStateListener { firebaseAuth ->
            _currentUser.value = firebaseAuth.currentUser
            _authState.value = if (firebaseAuth.currentUser != null) {
                AuthState(true, firebaseAuth.currentUser)
            } else {
                AuthState(false, null)
            }
        }
    }
    
    /**
     * Sign in with email and password
     * @param email User email
     * @param password User password
     * @return AuthResult containing success or error information
     */
    suspend fun signInWithEmailAndPassword(email: String, password: String): AuthResult {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            AuthResult.Success(result.user)
        } catch (e: Exception) {
            AuthResult.Error(getErrorMessage(e))
        }
    }
    
    /**
     * Create a new user with email and password
     * @param email User email
     * @param password User password
     * @return AuthResult containing success or error information
     */
    suspend fun createUserWithEmailAndPassword(email: String, password: String): AuthResult {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            AuthResult.Success(result.user)
        } catch (e: Exception) {
            AuthResult.Error(getErrorMessage(e))
        }
    }
    
    /**
     * Send password reset email
     * @param email User email
     * @return AuthResult containing success or error information
     */
    suspend fun sendPasswordResetEmail(email: String): AuthResult {
        return try {
            auth.sendPasswordResetEmail(email).await()
            AuthResult.Success(null)
        } catch (e: Exception) {
            AuthResult.Error(getErrorMessage(e))
        }
    }
    
    /**
     * Sign out the current user
     */
    fun signOut() {
        auth.signOut()
    }
    
    /**
     * Get user-friendly error message from Firebase exceptions
     * Provides clear, accessible error messages for different authentication failures
     */
    private fun getErrorMessage(exception: Exception): String {
        return when {
            exception.message?.contains("email address is badly formatted") == true -> 
                "Please enter a valid email address."
            
            exception.message?.contains("password is invalid") == true -> 
                "Incorrect password. Please try again."
            
            exception.message?.contains("no user record") == true -> 
                "No account found with this email. Please check your email or create a new account."
            
            exception.message?.contains("password is too weak") == true -> 
                "Password is too weak. Please use a stronger password with at least 8 characters."
            
            exception.message?.contains("email address is already in use") == true -> 
                "This email is already registered. Please use a different email or try logging in."
            
            exception.message?.contains("network error") == true -> 
                "Network error. Please check your internet connection and try again."
            
            else -> "Authentication failed: ${exception.message}. Please try again."
        }
    }
    
    /**
     * Backward compatibility methods for existing code
     */
    suspend fun loginUser(email: String, password: String): AuthResult = 
        signInWithEmailAndPassword(email, password)
    
    suspend fun registerUser(email: String, password: String): AuthResult = 
        createUserWithEmailAndPassword(email, password)
    
    suspend fun resetPassword(email: String): AuthResult = 
        sendPasswordResetEmail(email)
}

/**
 * Sealed class representing authentication results
 */
sealed class AuthResult {
    data class Success(val user: FirebaseUser?) : AuthResult()
    data class Error(val message: String) : AuthResult()
}

/**
 * Data class representing authentication state
 * Used for providing clear visual feedback in the UI
 */
data class AuthState(
    val isAuthenticated: Boolean,
    val user: FirebaseUser?
)
