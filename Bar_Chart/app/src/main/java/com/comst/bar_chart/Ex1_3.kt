package com.comst.bar_chart

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Ex1_3() {

    val barDataList = listOf(0.2f, 0.4f, 0.6f, 0.8f, 1f)
    val fullHeight = 600.dp

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(600.dp)
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            barDataList.forEachIndexed { index, it ->

                var resultHeight by remember {
                    mutableStateOf(0.dp)
                }

                LaunchedEffect(true){
                    delay(1000L * index)
                    resultHeight = fullHeight * it
                }

                val animatedHeight by animateDpAsState(
                    targetValue = resultHeight,
                    animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(text = "${(it * 100).toInt()}%")

                    Box(
                        modifier = Modifier
                            .height(animatedHeight)
                            .width(30.dp)
                            .background(
                                Color.Black,
                                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                            )
                    ) {

                    }
                }
            }
        }
    }
}