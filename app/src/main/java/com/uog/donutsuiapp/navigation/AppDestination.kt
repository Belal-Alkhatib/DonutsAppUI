package com.uog.donutsuiapp.navigation

sealed class Screen(val rout: String){
    object WelcomeScreen: Screen("welcome_screen")
    object HomeScreen: Screen("home_screen")
    object DetailsScreen: Screen("details_screen")
    object FavoriteScreen: Screen("favorite_screen")
    object NotificationScreen: Screen("notification_screen")
    object BuyScreen: Screen("buy_screen")
    object ProfileScreen: Screen("profile_screen")
}