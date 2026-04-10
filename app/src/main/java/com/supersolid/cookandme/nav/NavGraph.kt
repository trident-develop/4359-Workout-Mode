package com.supersolid.cookandme.nav

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.supersolid.cookandme.ui.screens.LoadingScreen
import com.supersolid.cookandme.ui.screens.MainScreen
import com.supersolid.cookandme.ui.screens.NoInternetScreen
import com.supersolid.cookandme.ui.screens.WorkoutDetailsScreen
import com.supersolid.cookandme.viewmodel.WorkoutViewModel
import androidx.compose.runtime.collectAsState

object Routes {
    const val LOADING = "loading"
    const val MAIN = "main"
    const val NO_INTERNET = "no_internet"
    const val WORKOUT_DETAILS = "workout_details/{workoutId}"
    fun workoutDetails(id: Int) = "workout_details/$id"
}

@Composable
fun WorkoutNavGraph() {
    val navController = rememberNavController()
    val viewModel: WorkoutViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.LOADING) {
        composable(Routes.LOADING) {
            BackHandler() { }
            LoadingScreen(
                onComplete = {
                    navController.navigate(Routes.MAIN) {
                        popUpTo(Routes.LOADING) { inclusive = true }
                    }
                },
                noInter = {
                    navController.navigate(Routes.NO_INTERNET) {
                        popUpTo(Routes.LOADING) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.NO_INTERNET) {
            BackHandler() { }
            NoInternetScreen(
                onRetry = {
                    navController.navigate(Routes.LOADING) {
                        popUpTo(Routes.NO_INTERNET) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.MAIN) {
            MainScreen(
                viewModel = viewModel,
                onNavigateToDetails = { workoutId ->
                    viewModel.selectWorkout(workoutId)
                    navController.navigate(Routes.workoutDetails(workoutId))
                }
            )
        }

        composable(
            route = Routes.WORKOUT_DETAILS,
            arguments = listOf(navArgument("workoutId") { type = NavType.IntType })
        ) { backStackEntry ->
            val workoutId = backStackEntry.arguments?.getInt("workoutId")
                ?: viewModel.lastSelectedWorkoutId.collectAsState().value
            WorkoutDetailsScreen(
                workoutId = workoutId,
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
