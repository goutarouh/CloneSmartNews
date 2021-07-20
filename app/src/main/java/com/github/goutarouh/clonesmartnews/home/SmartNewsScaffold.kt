package com.github.goutarouh.clonesmartnews.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.github.goutarouh.clonesmartnews.home.bottomnavigation.BottomNavigationScreens
import com.github.goutarouh.clonesmartnews.home.bottomnavigation.SmartNewsBottomBar
import com.github.goutarouh.clonesmartnews.ui.home.NewsListScreen

@Composable
fun SmartNewsScaffold() {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            SmartNewsTopAppBar(
                navController = navController,
                shouldShowTopAppBar = true,
                updateNews = {},
                showSetting = {}
            )
        },
        bottomBar = {
            SmartNewsBottomBar(
                switchBottomTab = { tabRoute, currentRoute ->
                    if (tabRoute != currentRoute) {
                        navController.navigate(route = tabRoute) {
                            popUpTo(navController.graph.startDestinationId)
                        }
                    }
                },
                navController = navController,
                shouldShowBottomBar = true
            )
        },
    ) { padding ->
        SmartNewsNavigationHost(
            navController = navController
        )
    }
}