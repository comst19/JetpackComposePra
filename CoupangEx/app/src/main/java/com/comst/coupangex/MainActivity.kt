package com.comst.coupangex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comst.coupangex.ui.theme.CoupangExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoupangExTheme {
                // A surface container using the 'background' color from the theme
                CoupangEx()
            }
        }
    }
}

@Composable
fun CoupangEx() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column() {
            TopLageArea()
            TopSearchBarArea()
        }
    }
}

@Composable
fun TopLageArea() {

    Box {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            contentAlignment = Alignment.Center
        ) {
            Row() {
                Text(text = "C", fontSize = 30.sp, color = Color(0xFF964b00))
                Text(text = "O", fontSize = 30.sp, color = Color(0xFF964b00))
                Text(text = "U", fontSize = 30.sp, color = Color(0xFF964b00))
                Text(text = "P", fontSize = 30.sp, color = Color.Red)
                Text(text = "A", fontSize = 30.sp, color = Color.Yellow)
                Text(text = "N", fontSize = 30.sp, color = Color.Green)
                Text(text = "G", fontSize = 30.sp, color = Color.Blue)
            }

            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                modifier = Modifier
                    .align(
                        Alignment.CenterEnd
                    )
                    .padding(end = 20.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSearchBarArea() {

    var inputText by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
    ) {

        TextField(
            value = inputText,
            onValueChange = {
                inputText = it
            },
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            placeholder = { Text(text = "쿠팡에서 검색하세요") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoupangExTheme {
        TopLageArea()
        TopSearchBarArea()
    }
}