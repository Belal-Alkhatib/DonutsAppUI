package com.uog.donutsuiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uog.donutsuiapp.ui.screens.DetailsScreen
import com.uog.donutsuiapp.ui.screens.HomeScreen
import com.uog.donutsuiapp.ui.screens.WelcomeScreen
import com.uog.donutsuiapp.ui.theme.DonutsUIAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DonutsUIAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.rout){
                        composable(Screen.WelcomeScreen.rout){ WelcomeScreen(navController = navController)}
                        composable(Screen.HomeScreen.rout){ HomeScreen(navController = navController) }
                        composable(Screen.DetailsScreen.rout){ DetailsScreen(navController = navController) }
                    }
                    //WelcomeScreen()
                    //DetailsScreen()
                    //HomeScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DonutsUIAppTheme {
        Greeting("Android")
    }
}