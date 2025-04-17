package com.alkaidynamics.fourscore

import android.app.Application
import com.alkaidynamics.fourscore.data.firebase.FirebaseConfig
import com.alkaidynamics.fourscore.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Main application class for 4-Score Fitness
 * Initializes Firebase and Koin dependency injection
 */
class FourScoreApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize Firebase
        FirebaseConfig.initialize(this)
        
        // Initialize Koin
        startKoin {
            // Use Android logger for debug builds
            androidLogger(Level.ERROR)
            
            // Provide Android context
            androidContext(this@FourScoreApplication)
            
            // Load modules
            modules(
                listOf(
                    appModule,
                    authModule,
                    forgeModule,
                    optimizeModule,
                    uniteModule,
                    recoverModule
                )
            )
        }
    }
}
