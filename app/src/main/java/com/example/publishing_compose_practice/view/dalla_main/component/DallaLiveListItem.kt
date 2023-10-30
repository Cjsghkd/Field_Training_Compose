package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.example.publishing_compose_practice.ui.theme.DallaTypography.b8
import com.example.publishing_compose_practice.ui.theme.DallaTypography.b9
import com.example.publishing_compose_practice.ui.theme.DallaTypography.h4

@Composable
fun DallaLiveListItem(
    modifier: Modifier = Modifier,
    rank: Int? = null,
    miniIcon: Int? = null,
    toggle: Int? = null,
    badge: Int? = null,
    bjImage: Int,
    gender: Int,
    title: String,
    name: String,
    peopleCount: String,
    heartCount: String,
    isBooster: Boolean
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(112.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(112.dp, 112.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = painterResource(id = bjImage),
                contentDescription = "bjImage",
                contentScale = ContentScale.Crop
            )
            Column {
                if (toggle != null) {
                    Image(
                        modifier = Modifier.padding(top = 8.dp),
                        painter = painterResource(id = toggle),
                        contentDescription = "toggle"
                    )
                }
                Text(
                    modifier = Modifier
                        .width(170.dp)
                        .padding(
                            top = if (toggle == null) 8.dp
                            else 4.dp
                        ),
                    text = title,
                    style = h4,
                    color = Color(0xff303030),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.padding(top = 15.dp, bottom = 6.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (badge != null) {
                        Image(
                            painter = painterResource(id = badge),
                            contentDescription = "badge"
                        )
                    }
                    Image(
                        painter = painterResource(id = gender),
                        contentDescription = "gender"
                    )
                    Text(
                        text = name,
                        style = b8,
                        color = Color(0xff666666)
                    )
                }
                Row(
                    modifier = Modifier.padding(bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.people_g_s),
                        contentDescription = "people_g_s",
                        tint = Color.Unspecified
                    )
                    Text(
                        text = peopleCount,
                        style = b9,
                        color = Color(0xff999999)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(
                            id = if (isBooster) R.drawable.ico_booster_2
                            else R.drawable.heart
                        ),
                        contentDescription = "heart",
                        tint = Color.Unspecified
                    )
                    Text(
                        text = heartCount,
                        style = b9,
                        color = if (isBooster) Color(0xfffd3b7a)
                        else Color(0xff999999)
                    )
                }
            }
        }
        if (miniIcon != null) {
            Image(
                modifier = Modifier.padding(start = 93.dp, top = 8.dp),
                painter = painterResource(id = miniIcon),
                contentDescription = "miniIcon"
            )
        }
        if (rank != null) {
            Image(
                painter = painterResource(id = rank),
                contentDescription = "rank"
            )
        }
    }
}

@Preview
@Composable
fun DallaLiveListItemPreview() {
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