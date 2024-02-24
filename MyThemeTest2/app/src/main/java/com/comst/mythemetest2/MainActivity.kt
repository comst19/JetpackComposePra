package com.comst.mythemetest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comst.mythemetest2.ui.theme.MyThemeTest2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyThemeTest2Theme {
                // A surface container using the 'background' color from the theme
                Test1()
            }
        }
    }
}

@Composable
fun Test1() {

    Column() {
        Text(
            text = "여기는 제목",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(30.dp)
        )
        Text(
            text = "여기는 내용",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(30.dp)
        )
        Text(
            text = "여기는 하단글",
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(30.dp)
        )

        Text(
            text = "여기는 제목",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(30.dp)
        )
        Text(
            text = "여기는 내용",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(30.dp)
        )
        Text(
            text = "여기는 하단글",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(30.dp)
        )
    }
}

@Composable
fun Test2() {

    Column() {
        Text(
            text = "Display Large",
            style = MaterialTheme.typography.displayLarge
        )

        Text(
            text = "Display Medium",
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            text = "Display Small",
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            text = "Headline Large",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Headline Medium",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Headline Small",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Title Large",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Title Medium",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = "Title Small",
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = "Body Large",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Body Medium",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Body Small",
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = "Label Large",
            style = MaterialTheme.typography.labelLarge
        )

        Text(
            text = "Label Medium",
            style = MaterialTheme.typography.labelMedium
        )

        Text(
            text = "Label Small",
            style = MaterialTheme.typography.labelSmall
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyThemeTest2Theme {
        Test1()
    }
}