package com.alkaidynamics.fourscore

import android.app.Application
import com.google.firebase.FirebaseApp
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FourScoreApp : Application() {
    override fun onCreate() {
        super.onCreate()
        
        // Initialize Firebase
        FirebaseApp.initializeApp(this)
        
        // Initialize Dependency Injection
        startKoin {
            androidLogger()
            androidContext(this@FourScoreApp)
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
