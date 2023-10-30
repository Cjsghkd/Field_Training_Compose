package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.R
import com.example.publishing_compose_practice.model.DallaMainBannerModel
import com.example.publishing_compose_practice.ui.theme.ArrowBottomIcon
import com.example.publishing_compose_practice.ui.theme.DallaTypography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AdInfiniteLoopPager(
    modifier: Modifier = Modifier,
    DallaAdBannerList: List<Int>? = null,
    delayMs: Long
) {
    val pagerState = rememberPagerState()

    LaunchedEffect(Unit) {
        var initialPage = Int.MAX_VALUE / 2

        if (DallaAdBannerList != null) {
            while (initialPage % (DallaAdBannerList.size) != 0) {
                initialPage++
            }
        }

        pagerState.scrollToPage(initialPage)
    }

    LaunchedEffect(pagerState.currentPage) {
        launch {
            while (true) {
                delay(delayMs)
                withContext(NonCancellable) {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            }
        }
    }

    Box {
        HorizontalPager(
            modifier = modifier,
            count = Int.MAX_VALUE,
            state = pagerState,
        ) { index ->
            DallaAdBannerList?.get(index % DallaAdBannerList.size)?.let {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp),
                    painter = painterResource(id = it),
                    contentDescription = "ad_background",
                    contentScale = ContentScale.Crop
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = 15.dp)
                .background(
                    color = Color(0x66000000),
                    shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp)
                )
                .align(Alignment.BottomEnd),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 2.dp, end = 2.dp),
                text = "${(pagerState.currentPage % DallaAdBannerList!!.size) + 1} / ${DallaAdBannerList?.size}",
                style = DallaTypography.b7,
                color = Color(0xffffffff)
            )
            ArrowBottomIcon(modifier = Modifier.padding(end = 4.dp))
        }
    }
}

@Preview
@Composable
fun AdInfiniteLoopPagerPreview() {
    AdInfiniteLoopPager(
        delayMs = 3000L,
        DallaAdBannerList = listOf(
            R.drawable.ad_background_one,
            R.drawable.ad_background_two,
            R.drawable.ad_background_three,
            R.drawable.ad_background_four,
            R.drawable.ad_background_five
        )
    )
}