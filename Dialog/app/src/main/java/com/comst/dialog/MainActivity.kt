package com.comst.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.comst.dialog.ui.theme.DialogTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DialogEx()
                }
            }
        }
    }
}

@Composable
fun DialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text(text = "다이얼로그 열기")
        }
        Text(text = "카운터: $counter")
    }

    if (openDialog) {
        AlertDialog(onDismissRequest = {
            // 단계 1: 'openDialog'를 이용해 다이얼로그를 끌 수 있게 한다.
            openDialog = false
        }, confirmButton = {
            // 단계 2: "더하기" 버튼을 만들고 'counter'를 증가시킨다.
            // 다이얼로그도 끈다.
            Button(onClick = {
                openDialog = false
                counter++
            }) {
                Text(text = "더하기")
            }
        }, dismissButton = {
            // 단계 3: "취소" 버튼을 만들고 다이얼로그를 끈다.
            Button(onClick = {
                openDialog = false
            }) {
                Text(text = "취소")
            }
        }, title = {
            // 단계 4: 타이틀을 만든다. "더하기" 정도로 해보자
                   Text(text = "더하기")
        }, text = {
            // 단계 5: 다이얼로그에서 설명할 문구를 출력한다.
            Text(text = "더하기 버튼을 누르면 카운터를 증가합니다.\n 버튼을 눌러주세요.")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialogTheme {
        DialogEx()
    }
}