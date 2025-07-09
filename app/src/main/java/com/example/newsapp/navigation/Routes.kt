package com.example.newsapp.navigation

sealed class Routes(val route: String) {
    object Onboarding : Routes("onboarding")
    object Home : Routes("home")
    object Splash : Routes("splash")
    object Search : Routes("search")
    object AppStartNavigation : Routes("appStartNavigation")
    object DetailsScreen : Routes("detailsScreen")
    
}
