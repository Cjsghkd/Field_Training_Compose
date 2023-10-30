package com.example.publishing_compose_practice

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.model.DallaFollowingListItemModel
import com.example.publishing_compose_practice.model.DallaMainBannerModel
import com.example.publishing_compose_practice.ui.theme.ArrowRightIcon
import com.example.publishing_compose_practice.ui.theme.DallaTypography.h2
import com.example.publishing_compose_practice.view.dalla_main.AdInfiniteLoopPager
import com.example.publishing_compose_practice.view.dalla_main.DallaAppBar
import com.example.publishing_compose_practice.view.dalla_main.DallaBjFanTeamText
import com.example.publishing_compose_practice.view.dalla_main.DallaBottomNavigateBar
import com.example.publishing_compose_practice.view.dalla_main.DallaFollowingListItem
import com.example.publishing_compose_practice.view.dalla_main.DallaLiveListItem
import com.example.publishing_compose_practice.view.dalla_main.DallaNewListITem
import com.example.publishing_compose_practice.view.dalla_main.DallaTabBar
import com.example.publishing_compose_practice.view.dalla_main.DallaTipBar
import com.example.publishing_compose_practice.view.dalla_main.DallaTopListITem
import com.example.publishing_compose_practice.view.dalla_main.MainInfiniteLoopPager

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DallaMainScreen(modifier: Modifier = Modifier) {
    var isScrolled by remember { mutableStateOf(false) }
    var isAlarmed by remember { mutableStateOf(true) }
    var mainBannerCurrentY by remember { mutableStateOf(0f) }
    var tabBarCurrentY by remember { mutableStateOf(0f) }
    var background by remember { mutableStateOf(Color.Transparent) }
    var alpha by remember { mutableStateOf(0f) }
    var logoAlpha by remember { mutableStateOf(0f) }
    var tabPadding by remember { mutableStateOf(0.dp) }
    val listState = rememberLazyListState()

    val mainBannerList = listOf(
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
    )
    val dallaAdBannerList = listOf(
        R.drawable.ad_background_one,
        R.drawable.ad_background_two,
        R.drawable.ad_background_three,
        R.drawable.ad_background_four,
        R.drawable.ad_background_five
    )
    val followingList = listOf(
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_one,
            name = "달대리찡",
            isOnlined = true
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_two,
            name = "사랑이M",
            isOnlined = true
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_three,
            name = "달라쑝",
            isOnlined = true
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_four,
            name = "한개두개세개",
            isOnlined = true
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_five,
            name = "개팔자가상팔자",
            isOnlined = true
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_six,
            name = "아이유 닮은 저에",
            isOnlined = true
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_one,
            name = "쏭디제이",
            isOnlined = false
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_two,
            name = "신입N",
            isOnlined = false
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_three,
            name = "개팔자가상팔자",
            isOnlined = false
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_four,
            name = "한개두개세개",
            isOnlined = false
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_one,
            name = "쏭디제이",
            isOnlined = false
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_two,
            name = "신입N",
            isOnlined = false
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_three,
            name = "개팔자가상팔자",
            isOnlined = false
        ),
        DallaFollowingListItemModel(
            bjImage = R.drawable.bj_background_four,
            name = "한개두개세개",
            isOnlined = false
        ),
    )

    LaunchedEffect(mainBannerCurrentY) {
        when (mainBannerCurrentY.toInt()) {
            in 501..2000 -> {
                background = Color.Transparent
                alpha = 1f
                logoAlpha = 0f
                isScrolled = false
            }
            in 0..500 -> {
                alpha = 1f - (mainBannerCurrentY / 500f)
                logoAlpha = 1f - (mainBannerCurrentY / 500f)
                isScrolled = true
                background = Color(
                    red = 255,
                    green = 255,
                    blue = 255,
                    alpha = (alpha * 255).toInt()
                )
            }
            else -> {
                background = Color.White
                alpha = 1f
                logoAlpha = 1f
            }
        }
    }

    LaunchedEffect(tabBarCurrentY) {
        tabPadding = when (tabBarCurrentY.toInt()) {
            in 291..5000 -> { 0.dp }
            in 0..290 -> { (50 * (290 - tabBarCurrentY) / 290).dp }
            else -> { 50.dp }
        }
    }

    Scaffold(bottomBar = { DallaBottomNavigateBar() }) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues),
            state = listState
        ) {
            item {
                MainInfiniteLoopPager(
                    modifier = Modifier,
                    DallaMainBannerModelList = mainBannerList,
                    delayMs = 6000L
                )
            }
            item {
                Spacer(modifier = Modifier.height(14.dp))

                LazyRow(
                    modifier = Modifier.onGloballyPositioned {
                        mainBannerCurrentY = it.positionInRoot().y
                    },
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    itemsIndexed(followingList.slice(0..9)) { index, item ->
                        DallaFollowingListItem(
                            modifier = Modifier.padding(
                                start = if (index == 0) 16.dp
                                else 0.dp,
                                end = if (index == 9 && followingList.size <= 10) 16.dp
                                else 0.dp,
                            ),
                            bjImage = item.bjImage,
                            name = item.name,
                            isOnlined = item.isOnlined,
                        )
                    }
                    if (followingList.size > 10) {
                        item {
                            DallaFollowingListItem(
                                modifier = Modifier.padding(end = 16.dp),
                                count = followingList.size - 10,
                                isOvered = true
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "\uD83C\uDFC6 NOW TOP 10",
                        style = h2,
                        color = Color(0xff202020)
                    )
                    ArrowRightIcon()
                    Spacer(modifier = Modifier.weight(1f))
                    DallaBjFanTeamText()
                }

                Spacer(modifier = Modifier.height(12.dp))

                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(10) { count ->
                        DallaTopListITem(
                            modifier = Modifier.padding(
                                start = if (count == 0) 16.dp
                                else 0.dp,
                                end = if (count == 9) 16.dp
                                else 0.dp,
                            ),
                            bjImage = R.drawable.bj_background_one,
                            miniIcon = R.drawable.btn_mini_live,
                            number = R.drawable.number_w_1,
                            name = "달대리찡"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                DallaTipBar(modifier = Modifier.padding(horizontal = 16.dp))

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "\uD83C\uDF31 NEW BJ",
                    style = h2,
                    color = Color(0xff202020)
                )
                LazyRow(
                    modifier = Modifier.padding(top = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(10) { count ->
                        DallaNewListITem(
                            modifier = Modifier.padding(
                                start = if (count == 0) 16.dp
                                else 0.dp,
                                end = if (count == 9) 16.dp
                                else 0.dp,
                            ),
                            bjImage = R.drawable.bj_background_one,
                            name = "개팔자가상팔자슬프다"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                AdInfiniteLoopPager(
                    delayMs = 3000L,
                    DallaAdBannerList = dallaAdBannerList
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "\uD83D\uDE80 지금 라이브 중!",
                    style = h2,
                    color = Color(0xff202020)
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
            stickyHeader {
                DallaTabBar(
                    modifier = Modifier
                        .onGloballyPositioned {
                            tabBarCurrentY = it.positionInRoot().y
                        }
                        .padding(top = tabPadding)
                )
            }
            item {
                Spacer(modifier = Modifier.height(12.dp))
                LazyColumn(
                    modifier = Modifier.heightIn(max = 1500.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(10) {
                        DallaLiveListItem(
                            rank = R.drawable.ani_time_01,
                            miniIcon = R.drawable.ico_video,
                            toggle = R.drawable.bdg_contents,
                            badge = R.drawable.ico_female,
                            bjImage = R.drawable.bj_background_one,
                            gender = R.drawable.ico_male,
                            title = "오늘도 화이팅하세요~!!!",
                            name = "쏭디제이",
                            peopleCount = "22",
                            heartCount = "234",
                            isBooster = true
                        )

                    }
                }
            }
        }
    }
    DallaAppBar(
        isScrolled = isScrolled,
        isAlarm = isAlarmed,
        backgroundColor = background,
        alpha = alpha,
        logoAlpha = logoAlpha
    )
}

@Preview
@Composable
fun DallaMainScreenPreview() {
    DallaMainScreen()
}