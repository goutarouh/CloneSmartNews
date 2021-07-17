package com.github.goutarouh.clonesmartnews

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.github.goutarouh.clonesmartnews.home.SmartNewsScaffold
import com.github.goutarouh.clonesmartnews.ui.home.NewsListScreen
import com.github.goutarouh.clonesmartnews.ui.theme.CloneSmartNewsTheme

@Composable
fun SmartNewsUiMain() {
    CloneSmartNewsTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            SmartNewsScaffold()
        }
    }
}