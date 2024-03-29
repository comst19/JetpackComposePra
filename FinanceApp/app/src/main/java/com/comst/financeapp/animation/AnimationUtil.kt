package com.comst.financeapp.animation

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat

@Composable
fun TextAnimation(
    targetValue: Int,
    textColor: Color,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    padding: PaddingValues
) {

    var startAnimation by remember { mutableStateOf(false) }

    val animationNumber = animateIntAsState(
        targetValue = if (startAnimation) targetValue else 0,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(Unit){
        startAnimation = true
    }

    val formattedNumber = NumberFormat.getNumberInstance().format(animationNumber.value)

    Text(
        text = "${formattedNumber}원",
        color = textColor,
        fontSize = fontSize,
        fontWeight = fontWeight,
        modifier = Modifier.padding(padding)
    )
}