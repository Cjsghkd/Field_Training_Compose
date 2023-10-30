package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.ui.theme.AlarmPoint
import com.example.publishing_compose_practice.ui.theme.DallaLogo
import com.example.publishing_compose_practice.ui.theme.TopBarIconSet

@Composable
fun DallaAppBar(
    modifier: Modifier = Modifier,
    isScrolled: Boolean,
    isAlarm: Boolean,
    backgroundColor: Color,
    alpha: Float,
    logoAlpha: Float
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
//                if (isScrolled) backgroundColor
//                else Color.Transparent
            backgroundColor
            )
            .alpha(alpha)
            .padding(start = 16.dp, end = 8.dp, top = 6.dp, bottom = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        DallaLogo(modifier = Modifier.alpha(logoAlpha))
        Box {
            TopBarIconSet(isScrolled = isScrolled)
            if (isAlarm) {
                AlarmPoint(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 3.dp, top = 1.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun DallaAppBarPreview() {
    DallaAppBar(
        isScrolled = true,
        isAlarm = false,
        backgroundColor = Color(0xffffffff),
        alpha = 1f,
        logoAlpha = 1f
    )
}