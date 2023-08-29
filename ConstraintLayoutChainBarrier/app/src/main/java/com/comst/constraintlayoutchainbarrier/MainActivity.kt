package com.comst.constraintlayoutchainbarrier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.comst.constraintlayoutchainbarrier.ui.theme.ConstraintLayoutChainBarrierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutChainBarrierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintLayoutEx()
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutEx() {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(parent.top, margin = 18.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(parent.top, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    top.linkTo(parent.top, margin = 20.dp)
                }
        )

        // 1. 'createVerticalChain', 'createHorizontalChain'
        // 이용해서 세 박스의 레퍼런스를 연결
//        createVerticalChain(redBox, yellowBox, magentaBox)
//        createHorizontalChain(redBox, yellowBox, magentaBox)

        // 2. createHorizontalChain를 사용하고 chainStyle
        // 키워드 파라미터를 추가하자
        // ChainStyle.Packed, ChainStyle.Spread,
        // ChainStyle.SpreadInside등을 지정
        createHorizontalChain(redBox, yellowBox, magentaBox, chainStyle = ChainStyle.SpreadInside)


        // 3. 세 박스의 top를 parent.top에 연결하고 각각 다른 마진을 주자

        // 4. createBottomBarrier로 배리어를 만들자
        // 이는 모든 박스들의 하단을 포함하는 배리어
        val barrier = createBottomBarrier(redBox, yellowBox, magentaBox)

        // 5. Text 하나 만들고 top을 박스 베리어로 지정
        Text(
            text = "나라말슴이 듕귁에 달아 어린 백성이... 나라말슴이 듕귁에 달아 어린 백성이...",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(barrier)
            })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayoutChainBarrierTheme {
        ConstraintLayoutEx()
    }
}