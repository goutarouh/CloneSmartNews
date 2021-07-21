package com.github.goutarouh.clonesmartnews.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.goutarouh.clonesmartnews.home.bottomnavigation.BottomNavigationScreens
import com.github.goutarouh.clonesmartnews.home.bottomnavigation.NewsScreen

@Composable
fun SmartNewsNavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreens.Home.route
    ) {
        bottomTabs(navController)
    }
}

private fun NavGraphBuilder.bottomTabs(
    navController: NavHostController
) {
    composable(BottomNavigationScreens.Home.route) { backStack ->
        NewsScreen()
    }
    composable(BottomNavigationScreens.Weather.route) { backStack ->
        Text(text = "Weather")
    }
    composable(BottomNavigationScreens.Coupon.route) { backStack ->
        Text(text = "Coupon")
    }
    composable(BottomNavigationScreens.Search.route) { backStack ->
        Text(text = "Search")
    }
    composable(BottomNavigationScreens.Account.route) { backStack ->
        Text(text = "Account")
    }
}