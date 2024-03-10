package com.comst.calendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comst.calendar.ui.theme.CalendarTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    CalendarHeader()
                    CalendarDayNames()
                }
            }
        }
    }
}


@Composable
fun CalendarHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.End
    ) {

        FaIcon(
            faIcon = FaIcons.Cog,
            size = 30.dp,
            tint = Color.Gray,
            modifier = Modifier.padding(end = 10.dp)
        )

        FaIcon(
            faIcon = FaIcons.Bell,
            size = 30.dp,
            tint = Color.Gray,
            modifier = Modifier.padding(end = 10.dp)
        )

        FaIcon(
            faIcon = FaIcons.Bars,
            size = 30.dp,
            tint = Color.Gray,
            modifier = Modifier.padding(end = 10.dp)
        )
    }
}

@Composable
fun CalendarDayNames() {

    val nameList = listOf("일", "월", "화", "수", "목", "금", "토")

    Row() {
        nameList.forEach {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = it, fontSize = 14.sp)
            }
        }
    }
}