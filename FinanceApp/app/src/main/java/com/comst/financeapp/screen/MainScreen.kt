package com.comst.financeapp.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comst.financeapp.ui.theme.FinanceAppTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Composable
fun MainScreen() {

    FaIcon(
        faIcon = FaIcons.ChartBarRegular,
        size = 50.dp,
        tint = Color.Red
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FinanceAppTheme {
        MainScreen()
    }
}