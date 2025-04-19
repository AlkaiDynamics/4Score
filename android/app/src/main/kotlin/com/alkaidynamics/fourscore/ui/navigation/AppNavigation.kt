package com.alkaidynamics.fourscore.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alkaidynamics.fourscore.ui.screens.auth.LoginScreen
import com.alkaidynamics.fourscore.ui.screens.auth.RegisterScreen
import com.alkaidynamics.fourscore.ui.screens.auth.ForgotPasswordScreen
import com.alkaidynamics.fourscore.ui.screens.home.HomeScreen
import com.alkaidynamics.fourscore.ui.screens.forge.ForgeScreen
import com.alkaidynamics.fourscore.ui.screens.optimize.OptimizeScreen
import com.alkaidynamics.fourscore.ui.screens.unite.UniteScreen
import com.alkaidynamics.fourscore.ui.screens.recover.RecoverScreen
import com.alkaidynamics.fourscore.ui.screens.profile.ProfileScreen

/**
 * Navigation routes for the application
 */
object NavRoutes {
    // Auth routes
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val FORGOT_PASSWORD = "forgot_password"
    
    // Main routes
    const val HOME = "home"
    
    // F.O.U.R. module routes
    const val FORGE = "forge"
    const val OPTIMIZE = "optimize"
    const val UNITE = "unite"
    const val RECOVER = "recover"
    
    // Profile route
    const val PROFILE = "profile"
}

/**
 * Main navigation component for the application
 * Handles navigation between screens based on authentication state
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavRoutes.LOGIN,
    isAuthenticated: Boolean = false
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = if (isAuthenticated) NavRoutes.HOME else startDestination,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Auth routes - only accessible when not authenticated
            composable(NavRoutes.LOGIN) {
                LoginScreen(
                    onLoginSuccess = { navController.navigate(NavRoutes.HOME) },
                    onRegisterClick = { navController.navigate(NavRoutes.REGISTER) },
                    onForgotPasswordClick = { navController.navigate(NavRoutes.FORGOT_PASSWORD) }
                )
            }
            
            composable(NavRoutes.REGISTER) {
                RegisterScreen(
                    onRegisterSuccess = { navController.navigate(NavRoutes.HOME) },
                    onLoginClick = { navController.navigate(NavRoutes.LOGIN) }
                )
            }
            
            composable(NavRoutes.FORGOT_PASSWORD) {
                ForgotPasswordScreen(
                    onBackToLoginClick = { navController.navigate(NavRoutes.LOGIN) }
                )
            }
            
            // Main routes - only accessible when authenticated
            composable(NavRoutes.HOME) {
                HomeScreen(
                    onForgeClick = { navController.navigate(NavRoutes.FORGE) },
                    onOptimizeClick = { navController.navigate(NavRoutes.OPTIMIZE) },
                    onUniteClick = { navController.navigate(NavRoutes.UNITE) },
                    onRecoverClick = { navController.navigate(NavRoutes.RECOVER) },
                    onProfileClick = { navController.navigate(NavRoutes.PROFILE) }
                )
            }
            
            // F.O.U.R. module screens
            composable(NavRoutes.FORGE) {
                ForgeScreen(
                    onBackClick = { navController.navigateUp() }
                )
            }
            
            composable(NavRoutes.OPTIMIZE) {
                OptimizeScreen(
                    onBackClick = { navController.navigateUp() }
                )
            }
            
            composable(NavRoutes.UNITE) {
                UniteScreen(
                    onBackClick = { navController.navigateUp() }
                )
            }
            
            composable(NavRoutes.RECOVER) {
                RecoverScreen(
                    onBackClick = { navController.navigateUp() }
                )
            }
            
            // Profile screen
            composable(NavRoutes.PROFILE) {
                ProfileScreen(
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    }
}
