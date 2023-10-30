package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.R
import com.example.publishing_compose_practice.ui.theme.DallaTypography.b5
import com.example.publishing_compose_practice.ui.theme.DallaTypography.b7

@Composable
fun DallaNewListITem(
    modifier: Modifier = Modifier,
    bjImage: Int,
    name: String
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
        Text(
            modifier = Modifier
                .width(100.dp)
                .align(Alignment.BottomStart)
                .padding(start = 8.dp, bottom = 8.dp),
            text = name,
            style = b7,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun DallaNewListITemPreview() {
    DallaNewListITem(
        bjImage = R.drawable.bj_background_one,
        name = "개팔자가상팔자슬프다"
    )
}