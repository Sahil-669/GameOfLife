package com.example.conwaysgameoflife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.conwaysgameoflife.navigation.AppRoutes
import com.example.conwaysgameoflife.ui.GameScreen
import com.example.conwaysgameoflife.ui.HelpScreen
import com.example.conwaysgameoflife.ui.LifeViewModel
import com.example.conwaysgameoflife.ui.StartScreen
import com.example.conwaysgameoflife.ui.StartViewModel
import com.example.conwaysgameoflife.ui.theme.ConwaysGameOfLifeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConwaysGameOfLifeTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppRoutes.StartScreen.route
    ) {
        composable(AppRoutes.StartScreen.route) {
            val viewModel: StartViewModel = viewModel()
            val gridWidth by viewModel.gridWidth.collectAsState()
            val gridHeight by viewModel.gridHeight.collectAsState()

            StartScreen(
                viewModel = viewModel,
                onNavigateToGame = {
                    navController.navigate(AppRoutes.GameScreen.createRoute(gridWidth,gridHeight))
                },
                onNavigateToHelp = {
                    navController.navigate(AppRoutes.HelpScreen.route)
                }
            )
        }

        composable(AppRoutes.HelpScreen.route) {
            HelpScreen(
                onExit = {navController.popBackStack()}
            )
        }

        composable(
            route = AppRoutes.GameScreen.route,
            arguments = listOf(
                navArgument("width") {type = NavType.IntType},
                navArgument("height") {type = NavType.IntType}
            )
        ) {
            backStackEntry ->
            val width = backStackEntry.arguments?.getInt("width") ?: 20
            val height = backStackEntry.arguments?.getInt("height") ?: 20
            val viewModel : LifeViewModel = viewModel()
            LaunchedEffect(Unit) {
                viewModel.initGame(width, height)
            }
            GameScreen(viewModel = viewModel)
        }
    }
}
