package com.comst.graphapp.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.comst.graphapp.ui.theme.GraphAppTheme

@Composable
fun Graph2() {

    Text(text = "2", fontSize = 30.sp)
}

@Preview(showBackground = true)
@Composable
fun Graph2Preview() {
    GraphAppTheme {
        Graph2()
    }
}