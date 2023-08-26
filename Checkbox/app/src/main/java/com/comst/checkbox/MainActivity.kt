package com.comst.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.comst.checkbox.ui.theme.CheckboxTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckboxTheme {
                CheckBoxEx()
            }
        }
    }
}

@Composable
fun CheckBoxEx() {
    Row(verticalAlignment = Alignment.CenterVertically) {

        // 1. Checkbox를 만들어 보기, checked 속성은 false
        // onCheckedChange는 비워둠
        
//        Checkbox(checked = false, onCheckedChange = {})

        // 2. onCheckedChange에서 boolean 값 변수를 바꿈
        // checked에서 그 값을 변형 - 잘 안 된다
//        var checked = false
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked =!checked
//            }
//        )


        // 3. booldea 대신 remember { mutableStateOf(false) }를
        // 사용하여 상태를 도입하자. value 프로퍼티를 이용해야 한다
//        var checked =  remember {mutableStateOf(false)}
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = {
//                checked.value =!checked.value
//            }
//        )

        // 위임된 속성
        // var checked = rember {mutableState(false)}
        // checked가 프로퍼티인 것 처럼
        // 4. delegated properties로 변경
        //import androidx.compose.runtime.getValue
        //import androidx.compose.runtime.setValue
//        var checked by  remember { mutableStateOf(false) }
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked =!checked
//            }
//        )

        // 비구조화
        // 5. destruction으로 상태를 받자
        val (getter, setter) =  remember { mutableStateOf(false) }
        Checkbox(
            checked = getter,
            onCheckedChange = setter
        )
        
        // checkbox를 앞에 넣어주세요
        Text(
            text = "프로그래머입니까",
            modifier = Modifier.clickable {
                setter(!getter)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CheckboxTheme {
        CheckBoxEx()
    }
}