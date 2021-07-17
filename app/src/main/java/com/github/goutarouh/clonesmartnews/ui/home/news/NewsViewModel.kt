package com.github.goutarouh.clonesmartnews.ui.home.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class NewsViewModel: ViewModel() {

    private val _newsList = MutableLiveData<List<NewsData>>()
    val newsList: LiveData<List<NewsData>> = _newsList


    init {
        getNewsList()
    }

    private fun getNewsList() {
        viewModelScope.launch {
            _newsList.value = NewsRepository.getNews()
        }
    }

}