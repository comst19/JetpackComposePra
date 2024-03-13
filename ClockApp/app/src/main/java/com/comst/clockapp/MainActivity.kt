package com.comst.clockapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comst.clockapp.ui.theme.ClockAppTheme
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClockAppTheme {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.padding(40.dp)) {
                    Clock()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Clock() {

    val context = LocalContext.current
    var inputText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text(text = "시간 입력 (1~60)") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Gray,
                unfocusedIndicatorColor = Color.White,
                cursorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = {

                try {
                    val number = inputText.toInt()
                    if (number in 1..60){

                    }else{
                        Toast.makeText(context, "1~60 사이의 값을 입력해주세요.", Toast.LENGTH_SHORT).show()
                    }
                }catch (e : Exception){
                    Toast.makeText(context, "숫자를 제대로 입력해주세요", Toast.LENGTH_SHORT).show()

                }


            },
            modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(text = "시간 설정", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Canvas(modifier = Modifier.fillMaxSize()){

            // 중심
            val center = Offset(size.width / 2, size.height / 2)

            // 반지름
            val radius = size.minDimension / 2

            // 0 ~ 59까지 60개 눈금을 그려야 함
            for (second in 0 until 60){

                // 시계가 360도, 60초 동안 한바퀴, 1초에 6 -> 6 * 60 = 360
                val angle = Math.toRadians(second * 6.0)

                // 원에서 조금 떨어진
                val startRadius = radius - 10.dp.toPx()

                // 원에서 많이 떨어지게
                val endRadius = radius

                val startX = center.x + cos(angle).toFloat() * startRadius
                val endX = center.x + cos(angle).toFloat() * endRadius

                val startY = center.y + sin(angle).toFloat() * startRadius
                val endY = center.y + sin(angle).toFloat() * endRadius

                drawLine(
                    Color.Black,
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    strokeWidth = 1.dp.toPx()
                )
            }
        }


    }
}