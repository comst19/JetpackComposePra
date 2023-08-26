@file:OptIn(ExperimentalMaterial3Api::class)

package com.comst.topappbar

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import com.comst.topappbar.ui.theme.TopAppBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopBarEx("Android")
                }
            }
        }
    }
}

@Composable
fun TopBarEx(name: String) {
    Column {

        // 1. TobAppBar를 만들고 title 항목을 채워보자
//        TopAppBar(
//            title = { Text(text = "TopAppBar") },
//            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow)
//        )

        // 2. navigationIcon 파라미터를 채워보자
        // IconButton을 만들고 자식으로 Icon을 넣자
        // Icons.Filled.ArrowBack 채우자
        // onClick은 비우자
//        TopAppBar(
//            title = { Text(text = "TopAppBar") },
//            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow),
//            navigationIcon = {
//                IconButton(onClick = {} ) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "업 네비게이션"
//                    )
//                }
//            }
//        )

        // 3. actions를 추가하자
        // Icons.Filled의 여러 아이콘을 이용해보자
        TopAppBar(
            title = { Text(text = "TopAppBar") },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow),
            navigationIcon = {
                IconButton(onClick = {} ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "업 네비게이션"
                    )
                }
            },
            actions = {
                IconButton(onClick = {} ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "검색"
                    )
                }
                IconButton(onClick = {} ) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "설정"
                    )
                }
                IconButton(onClick = {} ) {
                    Icon(
                        imageVector = Icons.Filled.AccountBox,
                        contentDescription = "계정"
                    )
                }
            }
        )



        Text(text = "Hello $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopAppBarTheme {
        TopBarEx("Android")
    }
}