package com.github.goutarouh.clonesmartnews.home

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.goutarouh.clonesmartnews.R

@Composable
fun SmartNewsTopAppBar(
    navController: NavHostController,
    shouldShowTopAppBar: Boolean,
    updateNews: () -> Unit,
    showSetting: () -> Unit
) {
    if (shouldShowTopAppBar) {
        Row(
            modifier = Modifier
                .fillMaxWidth().background(Color.Black),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = R.drawable.top_bar_update),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(12.dp))
            TextField(
                value = "gouta",
                modifier = Modifier.weight(1f, true),
                onValueChange = {}
            )
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painterResource(id = R.drawable.top_bar_settings),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}