package com.uog.donutsuiapp

sealed class Screen(val rout: String){
    object WelcomeScreen: Screen("welcome_screen")
    object HomeScreen: Screen("home_screen")
    object DetailsScreen: Screen("details_screen")
}