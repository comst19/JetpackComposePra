package com.comst.mythemetest3.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.comst.mythemetest3.R

val bmFont1 = FontFamily(Font(resId = R.font.bmdohyeon))
val bmFont2 = FontFamily(Font(resId = R.font.bmjua))


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = bmFont1,
        fontWeight = FontWeight.Normal,
        fontSize = 50.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = bmFont2,
        fontWeight = FontWeight.Normal,
        fontSize = 50.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    /*
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)