package com.example.publishing_compose_practice.ui.theme

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.publishing_compose_practice.R

@Composable
fun DallaLogo(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.dalla_logo),
        contentDescription = "dalla_logo",
        tint = tint
    )
}

@Composable
fun StarBadge(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.bdg_star),
        contentDescription = "bdg_star",
        tint = tint
    )
}

@Composable
fun TopBarIconSet(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    isScrolled: Boolean = false
) {
    if (isScrolled) {
        Icon(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ico_set),
            contentDescription = "ico_set",
            tint = tint
        )
    } else {
        Icon(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ico_set_white),
            contentDescription = "ico_set_white",
            tint = tint
        )
    }
}

@Composable
fun ArrowRightIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.v_icon),
        contentDescription = "v_icon",
        tint = tint
    )
}

@Composable
fun TipIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.img_tip),
        contentDescription = "img_tip",
        tint = tint
    )
}

@Composable
fun ArrowRightIcon2(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ico_drop_down),
        contentDescription = "ico_drop_down",
        tint = tint
    )
}

@Composable
fun ArrowBottomIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.banner_arrow),
        contentDescription = "banner_arrow",
        tint = tint
    )
}

@Composable
fun AlarmPoint(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ico_alarm_point),
        contentDescription = "ico_alarm_point",
        tint = tint
    )
}

