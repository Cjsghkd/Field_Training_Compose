package com.example.publishing_compose_practice.view.dalla_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.publishing_compose_practice.R

@Composable
fun DallaBottomNavigateBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 20.dp, vertical = 5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.footer_live),
            contentDescription = "footer_live"
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.footer_clip_d),
            contentDescription = "footer_live"
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.footer_plus),
            contentDescription = "footer_live"
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.footer_search_d),
            contentDescription = "footer_live"
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.footer_my_d),
            contentDescription = "footer_live"
        )
    }
}

@Preview
@Composable
fun DallaBottomNavigateBarPreview() {
    DallaBottomNavigateBar()
}