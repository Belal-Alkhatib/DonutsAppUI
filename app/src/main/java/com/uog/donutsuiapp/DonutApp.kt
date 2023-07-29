package com.uog.donutsuiapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uog.donutsuiapp.navigation.DonutsNavGraph
import com.uog.donutsuiapp.navigation.Screen
import com.uog.donutsuiapp.ui.composables.CustomBottomNavigation
import com.uog.donutsuiapp.ui.theme.DonutsUIAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DonutApp() {
    val navController = rememberNavController()

    DonutsUIAppTheme {

        Scaffold(bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            when (navBackStackEntry?.destination?.route) {
                Screen.HomeScreen.rout,
                Screen.FavoriteScreen.rout,
                Screen.NotificationScreen.rout,
                Screen.BuyScreen.rout,
                Screen.ProfileScreen.rout
                -> CustomBottomNavigation(navController = navController)
            }
        }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                DonutsNavGraph(navController = navController)
            }
        }
    }
}

