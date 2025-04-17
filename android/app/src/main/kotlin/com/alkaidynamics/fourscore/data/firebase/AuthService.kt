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
class AuthService {
    private val auth: FirebaseAuth = FirebaseConfig.getAuth()
    
    // Observable state flows for authentication state
    private val _currentUser = MutableStateFlow<FirebaseUser?>(auth.currentUser)
    val currentUser: StateFlow<FirebaseUser?> = _currentUser
    
    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState: StateFlow<AuthState> = _authState
    
    init {
        // Listen for authentication state changes
        auth.addAuthStateListener { firebaseAuth ->
            _currentUser.value = firebaseAuth.currentUser
            if (firebaseAuth.currentUser != null) {
                _authState.value = AuthState.Authenticated
            } else {
                _authState.value = AuthState.Unauthenticated
            }
        }
    }
    
    /**
     * Register a new user with email and password
     * @param email User email
     * @param password User password
     * @return AuthResult containing success or error information
     */
    suspend fun registerUser(email: String, password: String): AuthResult {
        return try {
            _authState.value = AuthState.Loading
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            _authState.value = AuthState.Authenticated
            AuthResult.Success(result.user)
        } catch (e: Exception) {
            _authState.value = AuthState.Error(getErrorMessage(e))
            AuthResult.Error(getErrorMessage(e))
        }
    }
    
    /**
     * Login with email and password
     * @param email User email
     * @param password User password
     * @return AuthResult containing success or error information
     */
    suspend fun loginUser(email: String, password: String): AuthResult {
        return try {
            _authState.value = AuthState.Loading
            val result = auth.signInWithEmailAndPassword(email, password).await()
            _authState.value = AuthState.Authenticated
            AuthResult.Success(result.user)
        } catch (e: Exception) {
            _authState.value = AuthState.Error(getErrorMessage(e))
            AuthResult.Error(getErrorMessage(e))
        }
    }
    
    /**
     * Send password reset email
     * @param email User email
     * @return AuthResult containing success or error information
     */
    suspend fun resetPassword(email: String): AuthResult {
        return try {
            _authState.value = AuthState.Loading
            auth.sendPasswordResetEmail(email).await()
            _authState.value = AuthState.PasswordResetEmailSent
            AuthResult.Success(null)
        } catch (e: Exception) {
            _authState.value = AuthState.Error(getErrorMessage(e))
            AuthResult.Error(getErrorMessage(e))
        }
    }
    
    /**
     * Sign out the current user
     */
    fun signOut() {
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
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
}

/**
 * Sealed class representing authentication results
 */
sealed class AuthResult {
    data class Success(val user: FirebaseUser?) : AuthResult()
    data class Error(val message: String) : AuthResult()
}

/**
 * Sealed class representing authentication states
 * Used for providing clear visual feedback in the UI
 */
sealed class AuthState {
    object Initial : AuthState()
    object Loading : AuthState()
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object PasswordResetEmailSent : AuthState()
    data class Error(val message: String) : AuthState()
}
