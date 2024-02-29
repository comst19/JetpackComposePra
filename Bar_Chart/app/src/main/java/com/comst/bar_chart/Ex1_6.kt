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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Ex1_6() {

    val barDataList = listOf(0.2f, 0.4f, 0.6f, 0.8f, 1f)
    val fullWidth = 320.dp

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                barDataList.forEachIndexed { index, it ->

                    var resultWidth by remember {
                        mutableStateOf(0.dp)
                    }

                    val animatedWidth by animateDpAsState(
                        targetValue = resultWidth,
                        animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
                    )

                    LaunchedEffect(true){
                        delay(1000L * index)
                        resultWidth = fullWidth * it
                    }

                    Row() {
                        Box(
                            modifier = Modifier
                                .width(animatedWidth)
                                .height(30.dp)
                                .background(
                                    Color.Black,
                                    shape = RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
                                )
                        ) {

                        }

                        Text(
                            text = "${(it * 100).toInt()}%",
                            modifier = Modifier.padding(top = 3.dp, start = 10.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }
        }
    }
}