package com.example.conwaysgameoflife.navigation

sealed class AppRoutes(val route: String) {
    object StartScreen : AppRoutes("start_screen")
    object HelpScreen : AppRoutes("help_screen")
    object GameScreen : AppRoutes("game_screen/{width}/{height}") {
        fun createRoute(width : Int, height: Int) = "game_screen/$width/$height"
    }
}