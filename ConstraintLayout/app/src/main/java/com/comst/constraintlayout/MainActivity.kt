package com.comst.constraintlayout

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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.comst.constraintlayout.ui.theme.ConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutTheme {
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

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // 2. createRefs()를 이용해서 아래 박스들의 레퍼런스를 가져옵시다.
        // createRefs는 여러개의 레퍼런스를 리턴하니 destruction으로 분해합시다.
        // red, meganta, green, yello 박스가 있습니다.
        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        Box (
            // 3. constraintsAs 모디파이어를 추가하고 레퍼런스를 전달합시다.
            // 후행 랃다로 top. start, end, bottom 앵커를 지정하고
            // linkTo를 호출
            // 인자로는 parent의 앵커 top, start, end, bottom을 전달

            // 4. linkTo의 키워드 인자 margin을 추가
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox){
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        )

        Box (
            // 5. 마젠타 박스를 parent의 start와 end에 연결하자
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox){
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box (
            // 6. 그린 박스를 linkto를 이용해서 정 가운데로 연결
            // 7. 앵커 메서드 linkto 대신에 centerto 함수를 사용
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox){
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)
                    centerTo(parent)
                }
        )

        Box (
            // 8. 옐로 박스를 마젠타 박스 오른쪽 대각선 아래에 위치
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox){
                    start.linkTo(magentaBox.end)
                    top.linkTo(magentaBox.bottom)
                }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConstraintLayoutTheme {
        ConstraintLayoutEx()
    }
}