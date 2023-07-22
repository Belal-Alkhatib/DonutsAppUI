package com.uog.donutsuiapp.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.uog.donutsuiapp.DonutsNavGraph
import com.uog.donutsuiapp.ui.theme.DonutsUIAppTheme

@Composable
fun DonutApp() {
    val systemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = false

    DonutsUIAppTheme {
        Surface {
            val navController = rememberNavController()
            DonutsNavGraph(navController = navController)
        }
    }
}