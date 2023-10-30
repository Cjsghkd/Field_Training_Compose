package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.ui.theme.ArrowRightIcon
import com.example.publishing_compose_practice.ui.theme.ArrowRightIcon2
import com.example.publishing_compose_practice.ui.theme.DallaTypography.b6
import com.example.publishing_compose_practice.ui.theme.TipIcon

@Composable
fun DallaTipBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xfffff3f7),
                shape = RoundedCornerShape(12.5.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TipIcon()
        Spacer(modifier = Modifier.width(11.dp))
        Text(
            text = buildAnnotatedString {
                append("타임랭킹 ")
                withStyle(
                    style = SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("1~3위")
                }
                append("시, ")
                withStyle(
                    style = SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append("스타BJ 가산점 ")
                }
                append("지급")
            },
            style = b6,
            color = Color(0xff303030)
        )
        Spacer(modifier = Modifier.weight(1f))
        ArrowRightIcon2(modifier = Modifier.padding(end = 5.dp))
    }
}

@Preview
@Composable
fun DallaTipBarPreview() {
    DallaTipBar()
}