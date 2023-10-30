package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.R
import com.example.publishing_compose_practice.ui.theme.DallaTypography.b2
import com.example.publishing_compose_practice.ui.theme.DallaTypography.h1

@Composable
fun DallaMainBannerIntroduce(
    modifier: Modifier = Modifier,
    toggle: Int?,
    title: String,
    name: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        Color.White
                    )
                )
            )
            .padding(start = 16.dp, end = 16.dp, top = 26.dp, bottom = 13.dp)
    ) {
        Column(modifier = Modifier.align(Alignment.BottomStart)) {
            if (toggle != null) {
                Image(
                    painter = painterResource(id = toggle),
                    contentDescription = "bdg_star"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                style = h1,
                color = Color(0xff202020)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = name,
                style = b2,
                color = Color(0xff202020)
            )
        }
    }
}

@Preview
@Composable
fun DallaMainBannerIntroducePreview() {
    DallaMainBannerIntroduce(
        toggle = R.drawable.bdg_contents,
        title = "하늘 닮은 DJ 늘 사랑 받는 아침방송",
        name = "애 나\uD835\uDC9C\uD835\uDCC3\uD835\uDCC3\uD835\uDCB6 \uD83D\uDCFB \uD83C\uDFA7"
    )
}