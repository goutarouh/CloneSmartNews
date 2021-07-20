package com.github.goutarouh.clonesmartnews.ui.home.news

import com.github.goutarouh.clonesmartnews.ui.home.news.NewsData
import kotlinx.coroutines.delay


object NewsRepository {

    suspend fun getGenreList(): List<NewsGenre> {
        delay(1000L)
        return listOf(
            NewsGenre(id = "1", name = "トップ", order = 0),
            NewsGenre(id = "2", name = "ワクチン", order = 1),
            NewsGenre(id = "3", name = "新型ウイルス", order = 2),
            NewsGenre(id = "4", name = "オリンピック", order = 3),
            NewsGenre(id = "5", name = "クーポン", order = 4),
            NewsGenre(id = "6", name = "エンタメ", order = 5),
            NewsGenre(id = "7", name = "スポーツ", order = 6),
            NewsGenre(id = "8", name = "混雑マップ", order = 7),
            NewsGenre(id = "9", name = "プレビュー", order = 8),
            NewsGenre(id = "10", name = "コラム", order = 9),
            NewsGenre(id = "11", name = "まとめ", order = 10)
        )
    }

    suspend fun getNewsList(): List<NewsData> {

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