package com.github.goutarouh.clonesmartnews.ui.home.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class NewsViewModel: ViewModel() {

    private val _genreList = MutableLiveData<List<NewsGenre>>()
    val genreList: LiveData<List<NewsGenre>> = _genreList

    private val _newsList = MutableLiveData<List<NewsData>>()
    val newsList: LiveData<List<NewsData>> = _newsList


    init {
        getGenreList()
        getNewsList()
    }

    private fun getGenreList() {
        viewModelScope.launch {
            _genreList.value = NewsRepository.getGenreList()
        }
    }

    private fun getNewsList() {
        viewModelScope.launch {
            _newsList.value = NewsRepository.getNewsList()
        }
    }

}