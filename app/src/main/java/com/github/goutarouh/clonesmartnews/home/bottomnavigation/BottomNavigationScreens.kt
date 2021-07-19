package com.github.goutarouh.clonesmartnews.home.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.github.goutarouh.clonesmartnews.R


sealed class BottomNavigationScreens(
    val route: String,
    val icon: Int
) {

    object Home: BottomNavigationScreens(
        "Home",
        R.drawable.bottom_item_home
    )

    object Weather: BottomNavigationScreens(
        "Weather",
        R.drawable.bottom_item_wether
    )

    object Coupon: BottomNavigationScreens(
        "Coupon",
        R.drawable.bottom_item_money
    )

    object Search: BottomNavigationScreens(
        "Search",
        R.drawable.bottom_item_search
    )

    object Account: BottomNavigationScreens(
        "Account",
        R.drawable.bottom_item_account
    )
}