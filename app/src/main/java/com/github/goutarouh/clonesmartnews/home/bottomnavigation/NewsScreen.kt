package com.github.goutarouh.clonesmartnews.home.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.goutarouh.clonesmartnews.ui.home.NewsListScreen
import com.github.goutarouh.clonesmartnews.ui.home.news.NewsViewModel
import com.github.goutarouh.clonesmartnews.ui.home.news.SmartNewsTabsScreen

@Composable
fun NewsScreen(
    viewModel: NewsViewModel = viewModel()
) {
    val selectedTabIndexState = remember { mutableStateOf(0) }
    Column {
        SmartNewsTabsScreen(
            selectedTabIndexState = selectedTabIndexState,
            viewModel = viewModel
        )
        NewsListScreen()
    }
}