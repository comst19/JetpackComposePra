package com.comst.bar_chart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Fill
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.drawscope.Stroke

data class ChartModel(val fraction: Float, val color: Color)

@Composable
fun Ex1_9() {

    val items = listOf(
        ChartModel(fraction = 0.2f, color = Color.Red),
        ChartModel(fraction = 0.3f, color = Color.Green),
        ChartModel(fraction = 0.5f, color = Color.Black)
    )

    var startAngle = 0f

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(300.dp)
        ) {

            items.forEach {

                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawArc(
                        color = it.color,
                        startAngle = startAngle,
                        sweepAngle = it.fraction * 360f - 2f,
                        useCenter = false,
                        size = Size(size.width, size.height),
                        style = Stroke(width = 200f)
                    )

                    startAngle += it.fraction * 360f

                }
            }
        }
    }


}