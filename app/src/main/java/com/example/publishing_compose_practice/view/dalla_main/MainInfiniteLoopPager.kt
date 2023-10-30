package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.R
import com.example.publishing_compose_practice.model.DallaMainBannerModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainInfiniteLoopPager(
    modifier: Modifier = Modifier,
    DallaMainBannerModelList: List<DallaMainBannerModel>? = null,
    delayMs: Long
) {
    val pagerState = rememberPagerState()

    LaunchedEffect(Unit) {
        var initialPage = Int.MAX_VALUE / 2

        if (DallaMainBannerModelList != null) {
            while (initialPage % (DallaMainBannerModelList.size) != 0) {
                initialPage++
            }
        }

        pagerState.scrollToPage(initialPage)
    }

    // 지정한 시간마다 auto scroll.
    // 유저의 스크롤해서 페이지가 바뀐경우 다시 실행시키고 싶기 때문에 key는 currentPage.
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

    HorizontalPager(
        modifier = modifier,
        count = Int.MAX_VALUE,
        state = pagerState,
    ) { index ->
        DallaMainBannerModelList?.get(index % DallaMainBannerModelList.size)?.let {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp),
                    painter = painterResource(id = it.bjImage),
                    contentDescription = "main_banner",
                    contentScale = ContentScale.Crop
                )
                DallaMainBannerIntroduce(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    toggle = it.toggle,
                    title = it.title,
                    name = it.name
                )
            }
        }
    }
}

@Preview
@Composable
fun InfiniteLoopPagerPreview() {
    MainInfiniteLoopPager(
        DallaMainBannerModelList = listOf(
            DallaMainBannerModel(
                bjImage = R.drawable.bj_background_one,
                toggle = R.drawable.bdg_star,
                title = "하늘 닮은 BJ 늘 사랑 받는\n아침방송",
                name = "애 나\uD835\uDC9C\uD835\uDCC3\uD835\uDCC3\uD835\uDCB6 \uD83D\uDCFB \uD83C\uDFA7",
            ),
            DallaMainBannerModel(
                bjImage = R.drawable.bj_background_two,
                toggle = R.drawable.bdg_contents,
                title = "아침방송",
                name = "애 나\uD835\uDC9C\uD835\uDCC3\uD835\uDCC3\uD835\uDCB6 \uD83D\uDCFB \uD83C\uDFA7",
            ),
            DallaMainBannerModel(
                bjImage = R.drawable.bj_background_three,
                toggle = null,
                title = "하늘",
                name = "애 나\uD835\uDC9C\uD835\uDCC3\uD835\uDCC3\uD835\uDCB6 \uD83D\uDCFB \uD83C\uDFA7",
            ),
            DallaMainBannerModel(
                bjImage = R.drawable.bj_background_four,
                toggle = R.drawable.bdg_star,
                title = "늘 사랑 받는\n아침방송",
                name = "애 나\uD835\uDC9C\uD835\uDCC3\uD835\uDCC3\uD835\uDCB6 \uD83D\uDCFB \uD83C\uDFA7",
            ),
            DallaMainBannerModel(
                bjImage = R.drawable.bj_background_five,
                toggle = R.drawable.bdg_newdj,
                title = "하늘 닮은 BJ 늘 사랑 받는",
                name = "애 나\uD835\uDC9C\uD835\uDCC3\uD835\uDCC3\uD835\uDCB6 \uD83D\uDCFB \uD83C\uDFA7",
            ),
            DallaMainBannerModel(
                bjImage = R.drawable.bj_background_six,
                toggle = null,
                title = "하늘 닮은 BJ 아침방송",
                name = "애 나\uD835\uDC9C\uD835\uDCC3\uD835\uDCC3\uD835\uDCB6 \uD83D\uDCFB \uD83C\uDFA7",
            )
        ),
        delayMs = 6000L
    )
}