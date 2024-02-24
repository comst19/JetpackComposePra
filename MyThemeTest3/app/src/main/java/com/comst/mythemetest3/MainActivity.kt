package com.comst.mythemetest3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.comst.mythemetest3.ui.theme.MyThemeTest3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyThemeTest3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Test()
                }
            }
        }
    }
}

@Composable
fun Test(){

    Column() {
        Text(text = "폰트1", style = MaterialTheme.typography.bodyLarge)
        Text(text = "폰트2", style = MaterialTheme.typography.titleLarge)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyThemeTest3Theme {
        Test()
    }
}