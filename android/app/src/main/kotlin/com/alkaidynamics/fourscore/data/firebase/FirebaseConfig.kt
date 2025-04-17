package com.alkaidynamics.fourscore.data.firebase

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

/**
 * Singleton class to manage Firebase configuration and provide access to Firebase services
 * Implements accessibility-first approach with clear error handling and visual feedback
 */
class FirebaseConfig private constructor() {
    
    // Firebase service instances
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore: FirebaseFirestore = Firebase.firestore
    private val storage: FirebaseStorage = Firebase.storage
    
    companion object {
        @Volatile
        private var INSTANCE: FirebaseConfig? = null
        
        /**
         * Initialize Firebase with the application context
         * Must be called before accessing any Firebase services
         */
        fun initialize(context: Context) {
            if (!FirebaseApp.getApps(context).isEmpty()) {
                // Firebase is already initialized
                return
            }
            
            try {
                FirebaseApp.initializeApp(context)
            } catch (e: Exception) {
                // Log error and provide visual feedback through UI
                // This will be handled by the UI layer
                throw FirebaseInitializationException("Failed to initialize Firebase: ${e.message}")
            }
        }
        
        /**
         * Get the Firebase configuration instance
         * Ensures thread-safety with double-checked locking
         */
        fun getInstance(): FirebaseConfig {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: FirebaseConfig().also { INSTANCE = it }
            }
        }
        
        // Convenience methods to access Firebase services
        fun getAuth(): FirebaseAuth = getInstance().auth
        fun getFirestore(): FirebaseFirestore = getInstance().firestore
        fun getStorage(): FirebaseStorage = getInstance().storage
    }
}

/**
 * Custom exception for Firebase initialization failures
 * Used to provide clear error messages for accessibility
 */
class FirebaseInitializationException(message: String) : Exception(message)
