package com.comst.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comst.text.ui.theme.TextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //Text(text = "Hello $name!", modifier = modifier)

    // 1. 색상을 지정하기 위해 color 파라미터에 Color.Red 전달
    //Text(color = Color.Red, text = "Hello $name!")

    // 2. Color 객체를 이용해서 해쉬값으로 색상을 전달 (ARGB)
    //Text(color = Color(0xffff9944), text = "Hello $name!")

    // 3. fontSize 파라미터에 30.sp를 전달
    //Text(color = Color.Red, text = "Hello $name!", fontSize = 30.sp)

    // 4. fontWeight에 FontWeight.Bold를 전달
    //Text(color = Color.Red, text = "Hello $name!", fontSize = 30.sp,fontWeight = FontWeight.Bold)

    // 5. fontFamily에 FontFamily.Cursive 전달 - Cursive 필기체,SansSerif 고딕? 등등
//    Text(
//        color = Color.Red,
//        text = "Hello $name!",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive
//    )

    // 6. letterSpacing 2.sp 지정 - 각 글자의 간격
//    Text(
//        color = Color.Red,
//        text = "Hello $name!",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp
//    )

    // 7. maxLines를 2로 지정하고 문자열을 더 추가
//    Text(
//        color = Color.Red,
//        text = "Hello $name!\nHello $name!\nHello $name!",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2
//    )

    // 8. textDecoration에 TextDecoration.Underline을 추가
//    Text(
//        color = Color.Red,
//        text = "Hello $name!\nHello $name!\nHello $name!",
//        fontSize = 30.sp,
//        fontWeight = FontWeight.Bold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 2,
//        textDecoration = TextDecoration.Underline
//    )

    // 9. textAlign을 TextAlign.Center로 지정, modifier을 사용하여 크기 늘리기
    Text(
        modifier = Modifier.size(300.dp),
        color = Color.Red,
        text = "Hello $name!\nHello $name!\nHello $name!",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextTheme {
        Greeting("Android")
    }
}