package com.github.goutarouh.clonesmartnews.ui.home

import kotlinx.coroutines.delay


object NewsRepository {

    suspend fun getNews(): List<NewsData> {

        delay(2000L)

        return List(50) {
            NewsData(
                id = "$it",
                title = "テストニュース${it}",
                imageUrl = "sample-url ${it}",
                publishedWhen = System.currentTimeMillis() - (10000 * (it * 1000)),
                publishedBy = "テスト会社${it}"
            )
        }
    }
}