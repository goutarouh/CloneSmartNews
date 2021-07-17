package com.github.goutarouh.clonesmartnews

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.goutarouh.clonesmartnews.ui.home.NewsListScreen
import com.github.goutarouh.clonesmartnews.ui.theme.CloneSmartNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloneSmartNewsTheme {
                SmartNewsUiMain()
            }
}
    }
}