package com.github.goutarouh.clonesmartnews

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.goutarouh.clonesmartnews.ui.home.NewsListScreen
import com.github.goutarouh.clonesmartnews.ui.theme.CloneSmartNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloneSmartNewsTheme {
                SmartNewsUiMain()
//                PreviewNewsList()
            }
        }
    }
}
@Composable
fun PreviewNewsList() {
    Button(
        onClick = {},
        modifier = Modifier.border(1.dp, Color.Red).size(100.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
    ) {
        Text(text = "button", modifier = Modifier.border(1.dp, Color.Green).fillMaxSize())
    }
}