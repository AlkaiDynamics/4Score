package com.alkaidynamics.fourscore.di

import com.alkaidynamics.fourscore.data.firebase.AuthService
import com.alkaidynamics.fourscore.data.firebase.UserProfileService
import com.alkaidynamics.fourscore.ui.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Main application module for dependency injection
 * Provides all services and viewmodels needed throughout the app
 */
val appModule = module {
    // Firebase services
    single { AuthService() }
    single { UserProfileService() }
    
    // ViewModels
    viewModel { LoginViewModel() }
    viewModel { RegisterViewModel() }
    viewModel { ForgotPasswordViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ForgeViewModel() }
    viewModel { OptimizeViewModel() }
    viewModel { UniteViewModel() }
    viewModel { RecoverViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { MainViewModel() }
}

/**
 * Authentication module for dependency injection
 * Provides authentication-related services and viewmodels
 */
val authModule = module {
    // Services
    single { AuthService() }
    single { UserProfileService() }
    
    // ViewModels
    viewModel { LoginViewModel() }
    viewModel { RegisterViewModel() }
    viewModel { ForgotPasswordViewModel() }
}

/**
 * Forge module for dependency injection
 * Provides workout-related services and viewmodels
 */
val forgeModule = module {
    // ViewModels
    viewModel { ForgeViewModel() }
}

/**
 * Optimize module for dependency injection
 * Provides nutrition-related services and viewmodels
 */
val optimizeModule = module {
    // ViewModels
    viewModel { OptimizeViewModel() }
}

/**
 * Unite module for dependency injection
 * Provides social-related services and viewmodels
 */
val uniteModule = module {
    // ViewModels
    viewModel { UniteViewModel() }
}

/**
 * Recover module for dependency injection
 * Provides recovery-related services and viewmodels
 */
val recoverModule = module {
    // ViewModels
    viewModel { RecoverViewModel() }
}
