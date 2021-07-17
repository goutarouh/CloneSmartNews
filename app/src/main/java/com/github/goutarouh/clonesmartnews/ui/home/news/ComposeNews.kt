package com.github.goutarouh.clonesmartnews.ui.home

import com.github.goutarouh.clonesmartnews.R
import android.text.format.DateUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.github.goutarouh.clonesmartnews.ui.home.news.NewsData
import com.google.accompanist.coil.rememberCoilPainter


@Composable
fun ComposeRightImageNews(
    newsData: NewsData
) {
    val modifier = Modifier
        .padding(all = 8.dp)
        .clickable {}

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val (title, publishedWhen, publishedBy, setting, image) = createRefs()


        Text(
            text = newsData.title,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(image.start, 8.dp)
                width = Dimension.fillToConstraints
            },
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = DateUtils.getRelativeTimeSpanString(
                newsData.publishedWhen,
                System.currentTimeMillis(),
                DateUtils.MINUTE_IN_MILLIS
            ).toString(),
            modifier = Modifier.constrainAs(publishedWhen) {
               bottom.linkTo(publishedBy.top, 2.dp)
            },
            color = Color(0xFF999999)
        )

        Text(
            text = newsData.publishedBy,
            modifier = Modifier.constrainAs(publishedBy) {
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            },
            color = Color(0xFF999999),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Image(
            painter = painterResource(id = R.drawable.drawable_more_horiz_24),
            contentDescription = null,
            modifier = Modifier.constrainAs(setting) {
                end.linkTo(image.start, 8.dp)
                bottom.linkTo(parent.bottom)
            },
        )


        if (newsData.imageUrl != null) {
            Image(
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                painter = rememberCoilPainter(newsData.imageUrl),
                contentDescription = null,
            )
        }
    }
}


// -------------------------------- preview --------------------------------


@Preview(
    name = "RightImageNewsPreview",
    widthDp = 400,
    heightDp = 112,
    showBackground = true
)
@Composable
private fun RightImageNewsPreview() {

    val newsData = NewsData(
        id = "test-id",
        title = "東京で新たに614人感染確認 ",
        imageUrl = "https://placehold.jp/100x100.png",
        publishedWhen = System.currentTimeMillis() - 20000000,
        publishedBy = "毎日新聞"
    )
    ComposeRightImageNews(newsData)
}