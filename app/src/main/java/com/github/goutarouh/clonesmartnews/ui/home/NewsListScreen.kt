package com.github.goutarouh.clonesmartnews.ui.home


import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NewsListScreen(
    viewModel: NewsViewModel = viewModel()
) {
    val newsList: List<NewsData> by viewModel.newsList.observeAsState(listOf())
    NewsList(newsList)
}

@Composable
private fun NewsList(newsList: List<NewsData>) {
    LazyColumn {
        items(items = newsList, key = { news -> news.id }) { news ->
            ComposeRightImageNews(news)
            Divider()
        }
    }
}

