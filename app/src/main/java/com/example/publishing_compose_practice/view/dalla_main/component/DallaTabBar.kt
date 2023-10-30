package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.publishing_compose_practice.ui.theme.DallaTypography

@Composable
fun DallaTabBar(modifier: Modifier = Modifier) {
    var isSelected by remember { mutableStateOf(0) }

    TabRow(
        modifier = modifier,
        selectedTabIndex = isSelected,
        containerColor = Color.White,
        divider = {},
        indicator = {
            val currentTabWidth by animateDpAsState(
                targetValue = it[isSelected].width,
                animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
                label = ""
            )
            val indicatorOffset by animateDpAsState(
                targetValue = it[isSelected].left,
                animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
                label = ""
            )

            Box(modifier = Modifier.fillMaxSize()) {
                Divider(
                    modifier = Modifier
                        .offset(indicatorOffset)
                        .width(currentTabWidth)
                        .height(5.dp)
                        .padding(horizontal = 35.dp)
                        .clip(RoundedCornerShape(2.5.dp))
                        .align(Alignment.BottomStart),
                    color = Color(0xffff3c7b)
                )
            }
        }
    ) {
        Tab(
            selected = true,
            onClick = { isSelected = 0 }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 14.dp),
                text = "전체",
                style = DallaTypography.h3,
                color = if (isSelected == 0) Color(0xff202020)
                else Color(0xffacacac)
            )
        }
        Tab(
            selected = false,
            onClick = { isSelected = 1 }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 14.dp),
                text = "VIDEO",
                style = DallaTypography.h3,
                color = if (isSelected == 1) Color(0xff202020)
                else Color(0xffacacac)
            )
        }
        Tab(
            selected = false,
            onClick = { isSelected = 2 }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 14.dp),
                text = "RADIO",
                style = DallaTypography.h3,
                color = if (isSelected == 2) Color(0xff202020)
                else Color(0xffacacac)
            )
        }
        Tab(
            selected = false,
            onClick = { isSelected = 3 }
        ) {
            Text(
                modifier = Modifier.padding(vertical = 14.dp),
                text = "신입BJ",
                style = DallaTypography.h3,
                color = if (isSelected == 3) Color(0xff202020)
                else Color(0xffacacac)
            )
        }
    }
}

@Preview
@Composable
fun DallaTabBarPreview() {
    DallaTabBar()
}