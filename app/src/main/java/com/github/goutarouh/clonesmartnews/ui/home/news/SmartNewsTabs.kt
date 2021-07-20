package com.github.goutarouh.clonesmartnews.ui.home.news

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

val tabColorList = listOf<Color>(
    Color(0xFFe84c3d),
    Color(0xFFEC9812),
    Color(0xFF2DC56E),
    Color(0xFF3396D9),
    Color(0xFF9958B2)
)

@Composable
fun SmartNewsTabsScreen(
    viewModel: NewsViewModel = viewModel()
) {
    val genreList: List<NewsGenre> by viewModel.genreList.observeAsState(listOf())

    if (genreList.isEmpty()) {
        Text("loading")
    } else {
        SmartNewsTabs(
            genreList = genreList
        )
    }

}

@Composable
fun SmartNewsTabs(
    genreList: List<NewsGenre>
) {
    var selectedTabIndex: Int by remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        edgePadding = 0.dp,
        indicator = {
            Box(
                modifier = Modifier
                    .wrapContentSize(Alignment.BottomStart)
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(color = tabColorList[selectedTabIndex % (tabColorList.size)])
            )
        },
        tabs = {
            genreList.forEachIndexed { index, genre ->
                Button(
                    onClick = { selectedTabIndex = index },
                    colors = ButtonDefaults.buttonColors(backgroundColor = tabColorList[index % (tabColorList.size)])
                ) {
                    Text(
                        text = genre.name,
                    )
                }
            }
        }
    )
}

fun Modifier.myTabModifier(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    // TODO: should we animate the width of the indicator as it moves between tabs of different
    // sizes inside a scrollable tab row?
    val currentTabWidth = currentTabPosition.width
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
}

