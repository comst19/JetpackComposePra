package com.comst.widgettest

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.ImageProvider
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

object TestWidget : GlanceAppWidget() {

    /*
    타이틀, 이미지 있는 위젯
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
     */

    /*
    버튼 클릭 이벤트

     */
    val countKey = intPreferencesKey("count")

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            val count = currentState(key = countKey) ?: 0
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .background(Color.DarkGray),
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = count.toString(),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        color = ColorProvider(Color.White),
                        fontSize = 26.sp
                    )
                )

                Button(
                    text = "Inc",
                    onClick = actionRunCallback(IncrementActionCallback::class.java)
                )

                Button(
                    text = "go Main",
                    onClick = actionStartActivity<MainActivity>()
                )
            }
        }
    }


}

class IncrementActionCallback : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, glanceId) { prefs ->
            val currentCount = prefs[TestWidget.countKey]
            if (currentCount != null) {
                prefs[TestWidget.countKey] = currentCount + 1
            } else {
                prefs[TestWidget.countKey] = 1
            }
        }

        TestWidget.update(context, glanceId)
    }

}