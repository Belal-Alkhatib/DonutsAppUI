package com.uog.donutsuiapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uog.donutsuiapp.ui.screens.DetailsScreen
import com.uog.donutsuiapp.ui.screens.HomeScreen
import com.uog.donutsuiapp.ui.screens.WelcomeScreen

@Composable
fun DonutsNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.rout){
        composable(Screen.WelcomeScreen.rout){ WelcomeScreen(navController = navController) }
        composable(Screen.HomeScreen.rout){ HomeScreen(navController = navController) }
        composable(Screen.DetailsScreen.rout){ DetailsScreen(navController = navController) }
    }
}