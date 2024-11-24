package com.comst.testconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.comst.testconstraintlayout.ui.theme.TestConstraintLayoutTheme

//https://charlezz.com/?p=45593

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestConstraintLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LargeConstraintLayoutO(innerPadding)
                }
            }
        }
    }
}

@Composable
fun TestConstraintLayout(paddingValues: PaddingValues){
    ConstraintLayout(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        val (button1, text1, text2) = createRefs()

        Button(
            onClick = { },
            modifier = Modifier
                .background(Color.Red)
                .constrainAs(button1){
                    top.linkTo(parent.top, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
        ){}

        Text(
            text = "text",
            modifier = Modifier
                .constrainAs(text1){
                    top.linkTo(button1.bottom)
                    end.linkTo(button1.start)
                }
        )

        Text("Text", Modifier.constrainAs(text2) {
            top.linkTo(button1.bottom, margin = 16.dp)
            // 텍스트를 ConstraintLayout 중앙에 정렬한다.
            centerHorizontallyTo(parent)
        })
    }
}


@Composable
fun DecoupledConstraintLayout(paddingValues: PaddingValues) {
    BoxWithConstraints {
        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp)
        } else {
            decoupledConstraints(margin = 32.dp)
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = {  },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}

@Composable
fun ConstraintLayoutContent(paddingValues: PaddingValues) {
    ConstraintLayout(
        modifier = Modifier.padding(paddingValues)
    ) {
        val (button1, button2, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button 1")
        }

        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerAround(button1.end)
        })

        val barrier = createEndBarrier(button1, text)
        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            }
        ) {
            Text("Button 2")
        }
    }
}

@Composable
fun LargeConstraintLayoutX(paddingValues: PaddingValues) {
    ConstraintLayout(
        modifier = Modifier.padding(paddingValues)
    ) {
        val text = createRef()

        val guideline = createGuidelineFromStart(fraction = 0.5f)
        Text(
            "This is a very very very very very very very long text",
            Modifier.constrainAs(text) {
                linkTo(start = guideline, end = parent.end)
            }
        )
    }
}

// wrapContent – 컨텐츠를 감싸면서 동적으로 사이즈를 변화시킨다. 심지어 주어진 제약 조건을 위반하면서 사이즈를 변경할 수 있다.(화면밖으로 벗어날 수 있음)
// preferredWrapContent – 기본적으로 wrapContent와 같지만, 주어진 제약조건내에서 컨텐츠를 감싼다. (화면 밖을 벗어나지 않음)
// fillToConstraints – 레이아웃을 확장시켜 해당 dimension의 제약조건에 의해 규정된 공간을 채운다.
// value -주어진 제약조건이 있음에도 레이아웃은 고정된 dp 값을 갖는다. (화면 밖을 벗어날 수 있음)
// preferredValue – 주어진 제약조건을 잘 지키며, 고정된 dp값을 갖는다. (화면 밖을 벗어나지 않음)

@Composable
fun LargeConstraintLayoutO(paddingValues: PaddingValues) {
    ConstraintLayout(
        modifier = Modifier.padding(paddingValues)
    ) {
        val text = createRef()

        val guideline = createGuidelineFromStart(0.5f)
        Text(
            "This is a very very very very very very very long text",
            Modifier.constrainAs(text) {
                linkTo(guideline, parent.end)
                width = Dimension.preferredWrapContent
            }
        )
    }
}


@Composable
fun OrientationAwareConstraintLayout(paddingValues: PaddingValues) {
    BoxWithConstraints {
        val isLandscape = maxWidth > maxHeight // 가로/세로 모드 판단
        val constraints = if (isLandscape) {
            landscapeConstraints(margin = 16.dp) // 가로 모드 제약 조건
        } else {
            portraitConstraints(margin = 16.dp) // 세로 모드 제약 조건
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
}

private fun landscapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin = margin)
            start.linkTo(parent.start, margin)
        }
        constrain(text) {
            top.linkTo(parent.top, margin = margin)
            start.linkTo(button.end, margin)
        }
    }
}