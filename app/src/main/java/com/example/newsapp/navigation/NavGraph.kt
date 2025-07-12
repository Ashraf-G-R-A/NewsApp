package com.example.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsapp.home.HomeViewModel
import com.example.newsapp.home.view.HomeScreen
import com.example.newsapp.onboarding.view.OnboardingScreen
import com.example.newsapp.splash.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Splash.route) {

        composable(route = Routes.Splash.route) {
            SplashScreen(navController = navController)

        }

        composable(route = Routes.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }

        composable(route = Routes.Home.route) {

            HomeScreen(navController = navController)
        }
        composable(route = Routes.Search.route) {
//            SearchScreen(navController = navController)
        }
    }
}
