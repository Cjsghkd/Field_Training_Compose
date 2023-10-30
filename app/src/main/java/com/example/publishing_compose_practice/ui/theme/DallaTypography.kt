package com.example.publishing_compose_practice.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.publishing_compose_practice.R

val suitFont = FontFamily(
    Font(R.font.suit_bold, FontWeight.Bold),
    Font(R.font.suit_medium, FontWeight.Medium),
    Font(R.font.suit_regular, FontWeight.Normal),
    Font(R.font.suit_semi_bold, FontWeight.SemiBold)
)

object DallaTypography {

    @Stable
    val h1 = TextStyle(
        fontFamily = suitFont,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 30.sp,
        letterSpacing = (-0.72).sp
    )

    @Stable
    val h2 = TextStyle(
        fontFamily = suitFont,
        fontSize = 19.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 31.sp,
        letterSpacing = (-0.57).sp
    )

    @Stable
    val h3 = TextStyle(
        fontFamily = suitFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    )

    @Stable
    val h4 = TextStyle(
        fontFamily = suitFont,
        fontSize = 15.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 18.sp
    )

    @Stable
    val h5 = TextStyle(
        fontFamily = suitFont,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 38.sp,
        letterSpacing = (-0.05).sp
    )


    @Stable
    val b1 = TextStyle(
        fontFamily = suitFont,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    )

    @Stable
    val b2 = TextStyle(
        fontFamily = suitFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.42).sp
    )

    @Stable
    val b3 = TextStyle(
        fontFamily = suitFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    )

    @Stable
    val b4 = TextStyle(
        fontFamily = suitFont,
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold,
    )

    @Stable
    val b5 = TextStyle(
        fontFamily = suitFont,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.75).sp
    )

    @Stable
    val b6 = TextStyle(
        fontFamily = suitFont,
        fontSize = 13.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 38.sp
    )

    @Stable
    val b7 = TextStyle(
        fontFamily = suitFont,
        fontSize = 13.sp,
        fontWeight = FontWeight.Medium,
    )

    @Stable
    val b8 = TextStyle(
        fontFamily = suitFont,
        fontSize = 13.sp,
        fontWeight = FontWeight.Normal,
    )

    @Stable
    val b9 = TextStyle(
        fontFamily = suitFont,
        fontSize = 13.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 26.sp
    )

}