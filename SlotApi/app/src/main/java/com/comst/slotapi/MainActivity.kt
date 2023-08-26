package com.comst.slotapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.comst.slotapi.ui.theme.SlotApiTheme
import org.w3c.dom.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotApiTheme {
                SlotEx()
            }
        }
    }
}

// 1. Row를 @Composable 함수로 분리
// checked의 값, text의 text를 인자로 전달

//@Composable
//fun CheckboxWithText(checked : MutableState<Boolean>, text : String){
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        Text(
//            text = text,
//            modifier = Modifier.clickable { checked.value = !checked.value }
//        )
//
//    }
//}

// 2. @Composable 함수에서 @Composable () -> Unit 타입으로
// content를 받아온다. Row의 Text를 빼고 content()를 넣자
// Row에 Modifier.clickable를 넣어 전체를 클릭가능하게 하자
//@Composable
//fun CheckboxWithSlot(
//    checked : MutableState<Boolean>,
//    content : @Composable () -> Unit
//){
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//
//    }
//}

// 3. content의 타입을 @Composable RowScope.() -> Unit로 바꾸자
// 이렇게 다른 콤포저블 컨텐트를 넣는 방식을 Slot API라 하자
//@Composable
//fun CheckboxWithSlot(
//    checked : MutableState<Boolean>,
//    content : @Composable RowScope.() -> Unit
//){
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//
//    }
//}

// 4. 상태를 바꾸는 람다를 @Composable 함수의 인자로 빼자
// 인자에서 MutableState대신 boolean값으로 변경
@Composable
fun CheckboxWithSlot(
    checked : Boolean,
    onCheckedChange : () -> Unit,
    content : @Composable RowScope.() -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChange()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange() }
        )
        content()

    }
}

@Composable
fun SlotEx() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

//    Column {
//        CheckboxWithSlot(checked1) {
//            Text("텍스트 1")
//        }
//        CheckboxWithSlot(checked2) {
//            Text("텍스트 2")
//        }
//    }

    Column {
        CheckboxWithSlot(
            checked = checked1,
            onCheckedChange = { checked1 = !checked1 }) {
            Text("텍스트 1")
        }
        CheckboxWithSlot(
            checked = checked2,
            onCheckedChange = { checked2 = !checked2}) {
            Text("텍스트 2")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SlotApiTheme {
        SlotEx()
    }
}