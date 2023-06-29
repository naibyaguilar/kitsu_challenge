package com.naiby.kitsuchallenge.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.naiby.kitsuchallenge.presentation.screens.detail.DetailScreen
import com.naiby.kitsuchallenge.presentation.screens.detail.DetailViewModel
import com.naiby.kitsuchallenge.presentation.screens.home.HomeScreen
import com.naiby.kitsuchallenge.presentation.screens.home.HomeViewModel
import com.naiby.kitsuchallenge.ui.theme.KitsuChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value
        }
        setContent {
            KitsuChallengeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    route = "home",
                    startDestination = "list"
                ) {
                    composable(route = "list") {
                        val viewModel: HomeViewModel = hiltViewModel()
                        val state by viewModel.uiState.collectAsStateWithLifecycle()
                        HomeScreen(state = state, onNavigateToDetailAnime = {
                            navController.navigate("detail/${it}")
                        })
                    }
                    composable(
                        route = "detail/{id}",
                        arguments = listOf(navArgument("id") {
                            type = NavType.StringType
                        })
                    ) {navBackStackEntry ->
//                        val id = navBackStackEntry.arguments?.getString("id")
                        val viewModel: DetailViewModel = hiltViewModel()
                        val state by viewModel.uiState.collectAsStateWithLifecycle()
                        DetailScreen(state = state)
                    }
                }
            }
        }
    }
}
