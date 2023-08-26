@file:OptIn(ExperimentalMaterial3Api::class)

package com.comst.scaffold

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.comst.scaffold.ui.theme.ScaffoldTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTheme {
                ScaffoldEx()
            }
        }
    }
}

@Composable
fun CheckBoxWithContent(
    checked : Boolean,
    toggleState : () -> Unit,
    content : @Composable RowScope.() -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleState() }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { toggleState()}
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldEx() {

    var checked by remember { mutableStateOf(false) }

    Scaffold(topBar = {
        // 1. topBar를 TopAppBar
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "뒤로 가기"
                    )
                }
            },
            title = {
                Text(text = "Scaffold App")
            },
        )
    },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                
            }
        }
    ){
        Surface(modifier = Modifier.padding(8.dp)) {
            // 2. 아래에 CheckBoxWithContent를 넣어보자
            CheckBoxWithContent(
                checked = checked,
                toggleState = { checked = !checked }
            ) {
                Text(text = "컴포즈를 좋아합니다.")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScaffoldTheme {
        ScaffoldEx()
    }
}