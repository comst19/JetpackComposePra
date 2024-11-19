package com.comst.widgettest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.ImageProvider
import androidx.glance.LocalSize
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

object TestWidget : GlanceAppWidget() {


    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            ResponsiveWidget()
        }
    }

    // 버튼 클릭
    val countKey = intPreferencesKey("count")

    @Composable
    fun ClickWidget(context: Context) {
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

            Button(
                text = "go Main - 값 전달",
                onClick = actionStartActivity(
                    Intent(context, MainActivity::class.java).apply {
                        action = Intent.ACTION_VIEW
                        putExtra("count", count)
                    }
                )
            )
        }
    }

    // sizeMode 연구 필요
    override val sizeMode = SizeMode.Responsive(
        setOf(
            WidgetSize.SMALL.size,
            WidgetSize.MEDIUM.size,
            WidgetSize.BIG.size,
        )
    )


    enum class WidgetSize(val size: DpSize) {
        SMALL(DpSize(60.dp, 100.dp)),
        MEDIUM(DpSize(60.dp, 200.dp)),
        BIG(DpSize(60.dp, 300.dp)),
    }

    @Composable
    private fun ResponsiveWidget() {
        val height = LocalSize.current.height
        when {
            height < 120.dp -> ResponsiveSmall()
            120.dp <= height && height <= 200.dp-> ResponsiveMedium()
            height > 200.dp -> ResponsiveBig()
        }
    }

    @Composable
    private fun ResponsiveSmall(){
        Text("SMALL",GlanceModifier.background(Color.Yellow))
    }

    @Composable
    private fun ResponsiveMedium(){
        Text("MEDIUM",GlanceModifier.background(Color.LightGray))
    }

    @Composable
    private fun ResponsiveBig(){
        Text("BIG",GlanceModifier.background(Color.Red))
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