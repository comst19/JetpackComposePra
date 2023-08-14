package com.comst.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comst.modifier.ui.theme.ModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierTheme {
                ModifierEx()
            }
        }
    }
}

@Composable
fun ModifierEx() {


    // 1. modifier에 Modifier.fillMaxSize()를 사용
//    Button(
//        onClick = {},
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Search")
//    }

    // 2. fillMaxSize대신 Modifier.height를 설정
//    Button(
//        onClick = {},
//        modifier = Modifier.height(100.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Search")
//    }

    // 3. modifier에 height와 width를 같이 설정해봅시다.
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .height(100.dp)
//            .width(200.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Search")
//    }

    // 4. size에 width와 height를 인자로 넣을 수도 있다.
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .size(width = 200.dp, height = 100.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Search")
//    }

    // 5. background를 설정해봅시다 (버튼에서는 되지 않음)
    // Button에 되지 않으면  Text나 Icon에 지정
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .size(width = 200.dp, height = 100.dp)
//            .background(Color.Red)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Search")
//    }

    // 6. colors 파라미터에 ButtonDefaults.buttonColors를 넣어보자
    // backgroundColor와 contentColor 프로퍼티를 설정
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .size(width = 200.dp, height = 100.dp),
//        colors = ButtonDefaults.buttonColors(Color.Magenta, contentColor = Color.Cyan),
//
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Search")
//    }

    // 7. Button의 modifier에 padding을 추가해보자
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .size(width = 200.dp, height = 100.dp)
//            .padding(10.dp),
//        colors = ButtonDefaults.buttonColors(Color.Magenta, contentColor = Color.Cyan),
//
//        ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "Search")
//    }

    // 8. Button에 enabled를 false로 설정하고, Text의
    // modifier에 clickable을 넣어보자
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .size(width = 200.dp, height = 100.dp)
//            .padding(10.dp),
//        colors = ButtonDefaults.buttonColors(Color.Magenta, contentColor = Color.Cyan),
//        enabled = false
//
//        ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(
//            text = "Search",
//            modifier = Modifier.clickable {}
//        )


    // 9. Text의 modifier에 offset를 설정하고 x 파라미터를 설정
    Button(
        onClick = {},
        modifier = Modifier
            .size(width = 200.dp, height = 100.dp)
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(Color.Magenta, contentColor = Color.Cyan)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
                .background(Color.Blue)
        )
        Text(
            text = "Search",
            modifier = Modifier.offset(x = 10.dp)
                .background(Color.Blue)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModifierTheme {
        ModifierEx()
    }
}