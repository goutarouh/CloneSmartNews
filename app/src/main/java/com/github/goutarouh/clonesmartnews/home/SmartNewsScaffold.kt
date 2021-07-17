package com.github.goutarouh.clonesmartnews.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.goutarouh.clonesmartnews.ui.home.NewsListScreen

@Composable
fun SmartNewsScaffold() {
    Scaffold(
        topBar = {
                 Box(modifier = Modifier
                     .fillMaxWidth()
                     .height(50.dp)
                     .background(Color.Red)
                 )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Blue)
            )
        },
    ) { padding ->
        Log.i("hasegawa", "SmartNewsScaffole ${padding}")
        NewsListScreen()
    }
}