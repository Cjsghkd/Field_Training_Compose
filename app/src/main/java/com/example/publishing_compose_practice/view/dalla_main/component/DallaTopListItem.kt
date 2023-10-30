package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.R
import com.example.publishing_compose_practice.ui.theme.DallaTypography.b5

@Composable
fun DallaTopListITem(
    modifier: Modifier = Modifier,
    bjImage: Int,
    miniIcon: Int,
    number: Int,
    name: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(modifier = modifier.size(116.dp, 154.dp)) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp)),
                painter = painterResource(bjImage),
                contentDescription = "bjImage",
                contentScale = ContentScale.Crop
            )
            Image(
                modifier = Modifier.align(Alignment.TopStart),
                painter = painterResource(miniIcon),
                contentDescription = "miniIcon"
            )
            Image(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 8.dp, bottom = 8.dp),
                painter = painterResource(id = number),
                contentDescription = "number"
            )
        }
        Text(
            text = name,
            style = b5,
            color = Color(0xff303030)
        )
    }
}

@Preview
@Composable
fun DallaTopListITemPreview() {
    DallaTopListITem(
        bjImage = R.drawable.bj_background_one,
        miniIcon = R.drawable.btn_mini_live,
        number = R.drawable.number_w_1,
        name = "달대리찡"
    )
}