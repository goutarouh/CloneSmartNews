package com.github.goutarouh.clonesmartnews.ui.home

data class NewsData(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val publishedWhen: Long,
    val publishedBy: String
)
