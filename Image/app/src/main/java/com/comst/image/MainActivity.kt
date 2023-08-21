package com.comst.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import com.comst.image.ui.theme.ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        
        // 1. Image를 만들어보자
        // Painter 항목에 PainterResource(id = R.drawable.~)
        // contentDescription에 엔텔로프 캐넌이라고 넣자
        Image(
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "엔텔로프 캐넌"
        )

        // Image
        // 2. 두 번째 Image를 만들어보자
        // ImageVector에 Icons.Filled.Settings를 설정
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )

//        Image(
//            bitmap = ,
//            contentDescription =
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageTheme {
        Greeting()
    }
}