package com.comst.widgettest

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.glance.GlanceId
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.appwidget.provideContent
import androidx.glance.text.Text
import androidx.glance.unit.ColorProvider

class TestWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            Scaffold(
                backgroundColor = ColorProvider(Color.LightGray),
                titleBar = {
                    TitleBar(
                        startIcon = ImageProvider(R.drawable.ic_launcher_foreground),
                        title = "Test"
                    )
                }
            ){
                Text("안녕안녕")
            }
        }
    }

}