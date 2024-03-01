package com.comst.bar_chart

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.text.NumberFormat

@Composable
fun Ex1_7(){

    var resultMoney by remember {
        mutableStateOf(0)
    }

    val animatedMoney by animateIntAsState(targetValue = resultMoney, animationSpec = tween(5000))

    val formattedResultMoney = NumberFormat.getNumberInstance().format(animatedMoney)

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "$formattedResultMoney 원", fontSize = 50.sp)

        Button(
            modifier = Modifier
                .width(150.dp)
                .padding(top = 150.dp),
            onClick = {
                resultMoney = 1000000000
            }
        ) {
            Text(text = "GO")
        }
    }
}