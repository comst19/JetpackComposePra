package com.comst.coil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.comst.coil.ui.theme.CoilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilTheme {
                CoilEx()
            }
        }
    }
}

@Composable
fun CoilEx() {
    // 3. rememberImagePainter을 이용해 Image의 painter를 설정
    // Compose 한국어 문서의 추천, but Deprecated
    // 이미지 URI :
//    val painter = rememberImagePainter(data = "https://t1.daumcdn.net/cfile/tistory/247D3737551FAE5D36")
//    Image(
//        painter = painter,
//        contentDescription = "엔텔로프 캐년"
//    )

    // 4. AsyncImage를 이용, model에 주소 적기
    Column {
        AsyncImage(
            model = "https://t1.daumcdn.net/cfile/tistory/247D3737551FAE5D36",
            contentDescription = "엔텔로프 캐년"
        )
        AsyncImage(
            model = "https://t1.daumcdn.net/cfile/tistory/247D3737551FAE5D36",
            contentDescription = "엔텔로프 캐년"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoilTheme {
        CoilEx()
    }
}