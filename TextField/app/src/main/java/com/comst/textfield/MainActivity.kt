package com.comst.textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comst.textfield.ui.theme.TextFieldTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTheme {
                // A surface container using the 'background' color from the theme
                Greeting()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {

    var name by remember { mutableStateOf("Tom") }
    Column(modifier = Modifier.padding(16.dp)) {

        // 1. TextField를 Text위에 만든다
        // value와 onValueChanged는 비워둔다.
//        TextField(value = "Tom", onValueChange = {})

        // 2. Text에 Android 대신 TextField 입력을 출력
        // mutableStateOf("")필드를 만들자
//        TextField(value = name, onValueChange = { name = it})

        // 3. TextField에 label을 추가
        // 내용에는 Text(Name)을 채워보자
//        TextField(
//            value = name,
//            label = {
//                    Text("이름")
//            },
//            onValueChange = { name = it}
//        )


        // 4. TextField와 Text 사이에 Spacer를 넣어 8.dp 간격을 주자
//        TextField(
//            value = name,
//            label = {
//                Text("이름")
//            },
//            onValueChange = { name = it}
//        )
//        Spacer(modifier = Modifier.size(8.dp))

        // 5. TextField를 OutlinedTextField로 변경
        OutlinedTextField(
            value = name,
            label = {
                Text("이름")
            },
            onValueChange = { name = it}
        )
        Spacer(modifier = Modifier.size(8.dp))


        Text(text = "Hello $name")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextFieldTheme {
        Greeting()
    }
}