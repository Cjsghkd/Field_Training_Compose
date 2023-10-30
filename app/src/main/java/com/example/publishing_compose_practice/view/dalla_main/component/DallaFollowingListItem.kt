package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.R
import com.example.publishing_compose_practice.ui.theme.DallaTypography.b1
import com.example.publishing_compose_practice.ui.theme.DallaTypography.h5

@Composable
fun DallaFollowingListItem(
    modifier: Modifier = Modifier,
    bjImage: Int = R.drawable.bj_background_one,
    count: Int = 0,
    name: String = "",
    isOnlined: Boolean = true,
    isOvered: Boolean = false
) {
    if (!isOvered) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Box {
                Canvas(modifier = Modifier.size(80.dp)) {
                    drawCircle(
                        brush = Brush.verticalGradient(
                            listOf(
                                if (isOnlined) Color(0xffff3c7b)
                                else Color(0xffcccccc),
                                if (isOnlined) Color(0xffff8565)
                                else Color(0xffe1e1e1)
                            )
                        )
                    )
                }
                Canvas(
                    modifier = Modifier
                        .size(76.dp)
                        .align(Alignment.Center),
                    onDraw = { drawCircle(Color.White) }
                )
                Image(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .align(Alignment.Center),
                    painter = painterResource(id = bjImage),
                    contentDescription = "bj_background",
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = name,
                style = b1,
                color = Color(0xFF303030)
            )
        }
    } else {
        Box(modifier = modifier) {
            Canvas(
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.Center),
                onDraw = { drawCircle(Color(0xfff6f6f6)) }
            )
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "+$count",
                style = h5,
                color = Color(0xffacacac)
            )
        }
    }
}

@Preview
@Composable
fun DallaFollowingListItemPreview() {
    DallaFollowingListItem(
        bjImage = R.drawable.bj_background_one,
        count = 24,
        name = "달대리찡",
        isOnlined = true,
        isOvered = true
    )
}