package com.comst.calendar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.comst.calendar.CalendarData.spendingData
import com.comst.calendar.ui.theme.CalendarTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons
import kotlinx.coroutines.flow.collect
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    CalendarHeader()

                    CalendarLazeList()
                }
            }
        }
    }
}


@Composable
fun CalendarHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.End
    ) {

        FaIcon(
            faIcon = FaIcons.Cog,
            size = 30.dp,
            tint = Color.Gray,
            modifier = Modifier.padding(end = 10.dp)
        )

        FaIcon(
            faIcon = FaIcons.Bell,
            size = 30.dp,
            tint = Color.Gray,
            modifier = Modifier.padding(end = 10.dp)
        )

        FaIcon(
            faIcon = FaIcons.Bars,
            size = 30.dp,
            tint = Color.Gray,
            modifier = Modifier.padding(end = 10.dp)
        )
    }
}

@Composable
fun CalendarDayNames() {

    val nameList = listOf("일", "월", "화", "수", "목", "금", "토")

    Row() {
        nameList.forEach {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = it, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun CalendarDayList() {

    val time = remember {
        mutableStateOf(Calendar.getInstance())
    }

    val date = time.value

    // 시간 세팅
    date.set(Calendar.YEAR, 2023)
    date.set(Calendar.MONTH, Calendar.DECEMBER)
    date.set(Calendar.DAY_OF_MONTH, 1)

    // 달력 계싼 공식 필요값
    val thisMonthDayMax = date.getActualMaximum(Calendar.DAY_OF_MONTH)
    val thisMonthFirstDay = date.get(Calendar.DAY_OF_WEEK) - 1
    val thisMonthWeeksCount = (thisMonthDayMax + thisMonthFirstDay + 6) / 7

    Column(modifier = Modifier.padding(top = 20.dp)) {

        repeat(thisMonthWeeksCount) { week ->
            Row() {
                repeat(7) { day ->
                    val resultDay = week * 7 + day - thisMonthFirstDay + 1

                    // 달력 날짜 범위 내
                    if (resultDay in 1..thisMonthDayMax) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(60.dp)
                                .border(1.dp, Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Top
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(20.dp)
                                        .background(Color(0xFF89CFF0))
                                )

                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = resultDay.toString(), fontSize = 14.sp)

                                }
                            }
                        }
                    } else {
                        // 범위 밖에
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(60.dp)
                                .border(1.dp, Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Top
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(20.dp)
                                        .background(Color(0xFF89CFF0))
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CalendarLazeList() {

    val lazyColumnState = rememberLazyListState()
    val lazyRowState = rememberLazyListState()
    val isScrolling = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        snapshotFlow { lazyColumnState.isScrollInProgress }.collect {
            isScrolling.value = it
            Log.d("isScrolling", "${isScrolling.value}")
        }
    }

    LaunchedEffect(lazyColumnState.firstVisibleItemIndex){
        lazyRowState.scrollToItem(lazyColumnState.firstVisibleItemIndex)
    }

    if (isScrolling.value) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            state = lazyRowState
        )
        {
            items(spendingData.size) {

                val day = it + 1

                Box(
                    modifier = Modifier
                        .width(55.dp)
                        .height(60.dp)
                        .border(1.dp, Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .background(Color(0xFF89CFF0))
                        )

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = day.toString(), fontSize = 14.sp)

                        }
                    }
                }
            }
        }
    } else {
        CalendarDayNames()
        CalendarDayList()
    }

    LazyColumn(
        modifier = Modifier.padding(20.dp),
        state = lazyColumnState
    )
    {
        spendingData.keys.forEach { day ->

            item {
                Text(
                    text = "2023년 12월 ${day}일",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                )

                spendingData[day]?.forEach { data ->
                    Row(modifier = Modifier.padding(start = 5.dp, top = 3.dp)) {
                        Text(text = data.type, fontSize = 12.sp)
                        Text(
                            text = "${data.price}",
                            fontSize = 12.sp,
                            color = if (data.type == "수입") Color.Red else Color.Blue,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }
            }
        }
    }
}