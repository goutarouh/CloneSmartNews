package com.github.goutarouh.clonesmartnews.home

import androidx.compose.foundation.layout.Row
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SmartNewsTopAppBar(
    navController: NavHostController,
    shouldShowTopAppBar: Boolean,
    updateNews: () -> Unit,
    showSetting: () -> Unit
) {
    TopAppBar(
        title = {
            if (shouldShowTopAppBar) {
                Row {

                }
            }
        }
    )
}