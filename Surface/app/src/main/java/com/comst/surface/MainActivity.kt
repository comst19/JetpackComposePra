package com.comst.surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comst.surface.ui.theme.SurfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurfaceTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(
//        modifier = Modifier.padding(5.dp)
//    ){
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(5.dp)
//        )
//    }

    // 1. Surface에 elevation을 설정
//    Surface(
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 5.dp
//    ){
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(5.dp)
//        )
//    }

    // 2. border의 값을 설정
//    Surface(
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 5.dp,
//        border = BorderStroke(width = 2.dp, color = Color.Magenta)
//    ){
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(5.dp)
//        )
//    }

    // 3. Surface의 shape도 설정
//    Surface(
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 10.dp,
//        border = BorderStroke(width = 2.dp, color = Color.Magenta),
//        shape = CircleShape
//    ){
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(5.dp)
//        )
//    }

    // 4. color를 지정합시다.
    Surface(
        modifier = Modifier.padding(5.dp),
        shadowElevation = 10.dp,
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.error
    ){
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(5.dp)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SurfaceTheme {
        Greeting("Android")
    }
}