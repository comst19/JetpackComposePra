package com.comst.button

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
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
import com.comst.button.ui.theme.ButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ButtonExample (onButtonClicked = {
                        Toast.makeText(this@MainActivity, "Send clicked.", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked : () -> Unit) {
    
//    Button(onClick = onButtonClicked){
//        Text(text = "send")
//    }

    // 1. Button을 클릭했을 때 Toast를 출력

    // 2. Icon을 Text 앞에 추가
    // imageVector에는 Icons.Filled.Send를 넣고
    // contentDescription에는 null를 넣자
//    Button(onClick = onButtonClicked){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Text(text = "send")
//    }

    // 3. 아이콘과 텍스트 사이에 Spacer를 넣어봅시다.
    // modifier에 Modifier.size를 넣고 사이즈를
    // ButtonDefaults.IconSpacing을 지정
//    Button(onClick = onButtonClicked, Modifier.size(width = 120.dp, height = 50.dp)){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "send")
//    }

    // 4. enabled를 false로 바꾸어보자
//    Button(onClick = onButtonClicked,
//        Modifier.size(width = 120.dp,
//            height = 50.dp),
//            enabled = false
//    ){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "send")
//    }

    // 5. border에 BorderStroke를 설정합시다.
//    Button(onClick = onButtonClicked,
//        Modifier.size(width = 120.dp,
//            height = 50.dp),
//        enabled = true,
//        border = BorderStroke(10.dp, Color.Magenta)
//    ){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "send")
//    }

    // 6. shape를 CircleShape로 지정
//    Button(onClick = onButtonClicked,
//        Modifier.size(width = 120.dp,
//            height = 50.dp),
//        enabled = true,
//        border = BorderStroke(10.dp, Color.Magenta),
//        shape = CircleShape
//    ){
//        Icon(
//            imageVector = Icons.Filled.Send,
//            contentDescription = null
//        )
//        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        Text(text = "send")
//    }

    // 7. contentPadding에 PaddingValues를 설정
    Button(onClick = onButtonClicked,
        Modifier.size(width = 120.dp,
            height = 50.dp),
        enabled = true,
        border = BorderStroke(10.dp, Color.Magenta),
        shape = CircleShape,
        contentPadding = PaddingValues(10.dp)
    ){
        Icon(
            imageVector = Icons.Filled.Send,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "send")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ButtonTheme {
        ButtonExample (onButtonClicked = {})
    }
}