package com.github.goutarouh.clonesmartnews.ui.home


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.goutarouh.clonesmartnews.ui.home.news.NewsData
import com.github.goutarouh.clonesmartnews.ui.home.news.NewsViewModel

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

@Preview(
    name = "PreViewNewsList",
    widthDp = 200
)
@Composable
fun PreviewNewsList() {
    NewsListScreen()
}

