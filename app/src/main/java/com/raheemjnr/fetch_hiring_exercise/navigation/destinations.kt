package com.raheemjnr.fetch_hiring_exercise.navigation


//sealed class to list out screens that will be available in app
sealed class MainScreen(val route: String) {
    object FetchScreen : MainScreen("fetchScreen")
}