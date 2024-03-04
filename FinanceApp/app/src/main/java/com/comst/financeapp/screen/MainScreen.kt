package com.comst.financeapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comst.financeapp.ui.theme.FinanceAppTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Composable
fun MainScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Black)
    ) {
        Header()
        TopMenu()
        TopMenuBottom()
    }


}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        FaIcon(
            faIcon = FaIcons.ArrowLeft,
            tint = Color.White,
            modifier = Modifier.padding(20.dp)
        )
        FaIcon(
            faIcon = FaIcons.Plus,
            tint = Color.White,
            modifier = Modifier.padding(20.dp)
        )

    }
}

@Composable
fun TopMenu() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Text(text = "자산", color = Color.Gray, fontSize = 16.sp)
        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Text(text = "소비·수입", color = Color.Gray, fontSize = 16.sp)
        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Text(text = "연말정산", color = Color.Gray, fontSize = 16.sp)
        }
    }
}

@Composable
fun TopMenuBottom() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {


        }

        Box(
            modifier = Modifier
                .weight(1f)
                .height(2.dp)
                .background(Color.White)
                .padding(top = 15.dp, start = 5.dp, end = 5.dp),
            contentAlignment = Alignment.Center
        ) {


        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {


        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FinanceAppTheme {
        MainScreen()
    }
}