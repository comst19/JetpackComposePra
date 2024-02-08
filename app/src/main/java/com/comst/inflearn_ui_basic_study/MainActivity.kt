package com.comst.inflearn_ui_basic_study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comst.inflearn_ui_basic_study.ui.theme.Inflearn_ui_basic_studyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Inflearn_ui_basic_studyTheme {
                // A surface container using the 'background' color from the theme
                MyTextField3()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField1() {

    var textState by remember { mutableStateOf("Hello") }

    TextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "입력하는 공간")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField2() {

    var textState by remember { mutableStateOf("Hello") }

    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        label = {
            Text(text = "입력하는 공간")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField3() {

    var textState by remember { mutableStateOf("") }

    var enteredText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = textState,
            onValueChange = {
                textState = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                enteredText = textState
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "입력하기")
        }

        Text(
            text = "결과값 텍스트 : ${enteredText}"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Inflearn_ui_basic_studyTheme {
        MyTextField3()
    }
}