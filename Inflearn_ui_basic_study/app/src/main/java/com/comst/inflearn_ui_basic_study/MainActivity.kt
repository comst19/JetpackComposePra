package com.comst.inflearn_ui_basic_study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.comst.inflearn_ui_basic_study.ui.theme.Inflearn_ui_basic_studyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Inflearn_ui_basic_studyTheme {
                // A surface container using the 'background' color from the theme
                ColumnRowTest2()
            }
        }
    }
}


@Composable
fun ColumnRowTest1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.Gray)
    ) {
        Text(
            text = "안녕하세요",
            color = Color.Blue,
            fontSize = 20.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "왼쪽")
            Text(text = "중앙")
            Text(text = "오른쪽")

        }

        Text(
            text = "반갑습니다.",
            color = Color.Red,
            fontSize = 20.sp
        )

    }
}

@Composable
fun ColumnRowTest2() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.Cyan)
            .border(
                border = BorderStroke(5.dp, color = Color.Blue)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.insider),
                contentDescription = "인사이더 프로젝트 이미지",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
        }

        Text(
            text = "컴쓰트",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 50.dp)
        )

        Text(
            text = "Android Developer",
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "이메일",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                text = "comst19@naver.com",
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp),
                color = Color.Blue
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "연락처",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                text = "000-0000-0000",
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp),
                color = Color.Blue
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Inflearn_ui_basic_studyTheme {
        ColumnRowTest2()
    }
}