package com.comst.widgettest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.comst.widgettest.ui.theme.WidgetTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WidgetTestTheme {
                setContent {
                    Scaffold { paddingValues ->
                        Box(
                            modifier = Modifier.padding(paddingValues).fillMaxSize()
                        ) {
                            Text("This is a normal Compose UI element")
                        }
                    }
                }
            }
        }
    }
}