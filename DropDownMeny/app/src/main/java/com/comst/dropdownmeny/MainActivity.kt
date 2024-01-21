package com.comst.dropdownmeny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.comst.dropdownmeny.ui.theme.DropDownMenyTheme
import androidx.compose.runtime.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropDownMenyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DropDownMenuEx()
                }
            }
        }
    }
}

@Composable
fun DropDownMenuEx() {
    var expandDropDownMenu by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { expandDropDownMenu = true }) {
            Text(text = "드롭다운 메뉴 열기")
        }
        Text(text = "카운터 : $counter")
    }

    // 단계 1: ''DropdownMenu' 만들고 'expanded'를 'expandDropDownMenu'로 등록
    // 'onDismissRequest'에 대해서는 'expandDropDownMenu'를 'false'로 바꾼다.
    DropdownMenu(
        expanded = expandDropDownMenu,
        onDismissRequest = {
            expandDropDownMenu = false
        }
    ) {
        DropdownMenuItem(text = { Text(text = "증가")}, onClick = {
            counter++
        })
        DropdownMenuItem(text = { Text(text = "감소")}, onClick = {
            counter--
        })
    }

    // 단계 2: 두개의 'DropdownMenuItem'을 등록하자. 'onClick'을 구현하고
    // 내용물은 'Text로 채우자'
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DropDownMenyTheme {
        DropDownMenuEx()
    }
}