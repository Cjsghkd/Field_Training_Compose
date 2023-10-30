package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.ui.theme.DallaTypography

@Composable
fun DallaBjFanTeamText(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "BJ",
            style = DallaTypography.b3,
            color = Color(0xff202020)
        )
        Divider(
            modifier = Modifier.size(width = 1.dp, height = 10.dp),
            color = Color(0xffcccccc)
        )
        Text(
            text = "FAN",
            style = DallaTypography.b3,
            color = Color(0xffacacac)
        )
        Divider(
            modifier = Modifier.size(width = 1.dp, height = 10.dp),
            color = Color(0xffcccccc)
        )
        Text(
            text = "TEAM",
            style = DallaTypography.b4,
            color = Color(0xffacacac)
        )
    }
}

@Preview
@Composable
fun DallaBjFanTeamTextPreview() {
    DallaBjFanTeamText()
}