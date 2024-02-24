package com.comst.mythemetest4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comst.mythemetest4.ui.theme.MyThemeTest4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyThemeTest4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RadiusTest1()
                }
            }
        }
    }
}

@Composable
fun RadiusTest1() {

    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(Color.Blue)
        ){

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.large)
                .background(Color.Blue)
        ){

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color.Blue)
        ){

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyThemeTest4Theme {
        RadiusTest1()
    }
}