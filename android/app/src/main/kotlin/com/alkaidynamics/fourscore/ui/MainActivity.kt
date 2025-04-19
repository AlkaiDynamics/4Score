package com.alkaidynamics.fourscore.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.alkaidynamics.fourscore.ui.navigation.FourScoreNavigation
import com.alkaidynamics.fourscore.ui.theme.FourScoreTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FourScoreApp()
        }
    }
}

@Composable
fun FourScoreApp() {
    FourScoreTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val navController = rememberNavController()
            val viewModel: MainViewModel = koinViewModel()
            
            // Main navigation component
            FourScoreNavigation(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}
