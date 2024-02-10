package com.comst.inflearn_ui_basic_study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                BoxExample()
            }
        }
    }
}

@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Blue)
                    .padding(16.dp)
                    .align(Alignment.TopStart)
            ) {
                Text(text = "왼쪽 위")
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Green)
                    .padding(16.dp)
                    .align(Alignment.TopCenter)
            ) {
                Text(text = "중앙 위")
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Gray)
                    .padding(16.dp)
                    .align(Alignment.TopEnd)
            ) {
                Text(text = "오른쪽 위")
            }

            Button(
                onClick = {  },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Text(text = "중앙 왼쪽")
            }

            Button(
                onClick = {  },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = "중앙")
            }

            Button(
                onClick = {  },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Text(text = "중앙 오른쪽")
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Blue)
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text(text = "왼쪽 아래")
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Green)
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text(text = "중앙 아래")
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Gray)
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Text(text = "오른쪽 아래")
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Inflearn_ui_basic_studyTheme {
        BoxExample()
    }
}