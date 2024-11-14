package com.comst.dragtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comst.dragtest.ui.theme.DragTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DragTestTheme {
                Scaffold { paddingValues ->
                    MultiDirectionalDraggableBox(paddingValues)
                }
            }
        }
    }
}

@Composable
fun AnimatedDragResizableBox(paddingValues: PaddingValues) {
    var size by remember { mutableStateOf(100.dp) }
    val animatedSize by animateDpAsState(targetValue = size)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(animatedSize)
                .background(Color.Blue)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        size = (size + dragAmount.y.dp).coerceIn(50.dp, 300.dp)
                    }
                }
        )
    }
}

@Composable
fun DraggableResizableBox(paddingValues: PaddingValues) {
    var size by remember { mutableStateOf(100.dp) }
    var dragOffset by remember { mutableStateOf(0f) }
    val animatedSize by animateDpAsState(targetValue = size)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(animatedSize)
                .background(Color.Blue)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { change, dragAmount ->
                            change.consume()
                            dragOffset += dragAmount.y
                        },
                        onDragEnd = {
                            size = (size + dragOffset.dp).coerceIn(50.dp, 300.dp)
                            dragOffset = 0f
                        }
                    )
                }
        )
    }
}

@Composable
fun FixedSizeDraggableBox(paddingValues: PaddingValues) {
    var size by remember { mutableStateOf(100.dp) }
    val animatedSize by animateDpAsState(targetValue = size)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(animatedSize)
                .background(Color.Blue)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { _, _ -> },
                        onDragEnd = {
                            size = if (size == 100.dp) 300.dp else 100.dp
                        }
                    )
                }
        )
    }
}

@Composable
fun DirectionalDraggableBox(paddingValues: PaddingValues) {
    var size by remember { mutableStateOf(100.dp) }
    val animatedSize by animateDpAsState(targetValue = size)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(animatedSize)
                .background(Color.Blue)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { change, dragAmount ->
                            change.consume()
                            if (dragAmount.y != 0f && kotlin.math.abs(dragAmount.y) > kotlin.math.abs(dragAmount.x)) {
                            }
                        },
                        onDragEnd = {
                            if (size == 100.dp) size = 300.dp else size = 100.dp
                        }
                    )
                }
        )
    }
}

@Composable
fun MultiDirectionalDraggableBox(paddingValues: PaddingValues) {
    var size by remember { mutableStateOf(100.dp) }
    val animatedSize by animateDpAsState(targetValue = size)
    var dragDirection by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(animatedSize)
                .background(Color.Blue)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { change, dragAmount ->
                            change.consume()
                            dragDirection = when {
                                dragAmount.y < 0 && kotlin.math.abs(dragAmount.y) > kotlin.math.abs(dragAmount.x) -> "UP"
                                dragAmount.y > 0 && kotlin.math.abs(dragAmount.y) > kotlin.math.abs(dragAmount.x) -> "DOWN"
                                dragAmount.x < 0 && kotlin.math.abs(dragAmount.x) > kotlin.math.abs(dragAmount.y) -> "LEFT"
                                dragAmount.x > 0 && kotlin.math.abs(dragAmount.x) > kotlin.math.abs(dragAmount.y) -> "RIGHT"
                                else -> dragDirection
                            }

                            Log.d("DragDirection", "Current drag direction: $dragDirection")
                        },
                        onDragEnd = {
                            Log.d("DragDirection", "Final drag direction on drag end: $dragDirection")
                            size = when (dragDirection) {
                                "UP" -> 200.dp
                                "DOWN" -> 300.dp
                                "LEFT" -> 150.dp
                                "RIGHT" -> 250.dp
                                else -> size
                            }
                            dragDirection = ""
                        }
                    )
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DragTestTheme {
    }
}