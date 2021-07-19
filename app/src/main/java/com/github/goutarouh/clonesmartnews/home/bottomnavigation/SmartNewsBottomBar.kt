package com.github.goutarouh.clonesmartnews.home.bottomnavigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

private val bottomNavigationItems = listOf(
    BottomNavigationScreens.Home,
    BottomNavigationScreens.Weather,
    BottomNavigationScreens.Coupon,
    BottomNavigationScreens.Search,
    BottomNavigationScreens.Account
)

@Composable
fun SmartNewsBottomBar(
    switchBottomTab: (String, String) -> Unit,
    navController: NavHostController,
    shouldShowBottomBar: Boolean
) {

    val currentRoute = currentRoute(navController)

    if (shouldShowBottomBar) {
        BottomNavigation(
            backgroundColor = Color.White
        ) {
            bottomNavigationItems.forEach { screen ->
                BottomNavigationTab(screen, switchBottomTab, currentRoute)
            }
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Composable
private fun RowScope.BottomNavigationTab(
    screen: BottomNavigationScreens,
    switchBottomTab: (String, String) -> Unit,
    currentRoute: String?
) {
    BottomNavigationItem(
        icon = {
               ComposeBottomNavIconState(currentRoute, screen)
        },
        label = { Text(text = screen.route) },
        selected = isSelected(currentRoute, screen),
        alwaysShowLabel = true,
        onClick = {
            currentRoute?.let { switchBottomTab(screen.route, it) }
        },
        selectedContentColor = Color(0xFF00acee),
        unselectedContentColor = Color.Gray
    )
}

@Composable
private fun isSelected(
    currentRoute: String?,
    screen: BottomNavigationScreens
): Boolean {
    return currentRoute == screen.route
}

@Composable
private fun ComposeBottomNavIconState(
    currentRoute: String?,
    screen: BottomNavigationScreens
) {
    when {
        isSelected(currentRoute, screen) -> {
            Icon(painter = painterResource(id = screen.icon), contentDescription = null)
        }
        else -> {
            Icon(painter = painterResource(id = screen.icon), contentDescription = null)
        }
    }
}