package com.raheemjnr.fetch_hiring_exercise.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raheemjnr.fetch_hiring_exercise.ui.screen.FetchExerciseScreen
import com.raheemjnr.fetch_hiring_exercise.ui.theme.Fetch_Hiring_ExerciseTheme

/** nav graph to navigate
 * to respective screens */
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MainScreenNavigation() {
    val navController = rememberNavController()
    Fetch_Hiring_ExerciseTheme() {
        NavHost(navController, startDestination = MainScreen.FetchScreen.route) {
            composable(MainScreen.FetchScreen.route) {
                FetchExerciseScreen()
            }
        }
    }
}