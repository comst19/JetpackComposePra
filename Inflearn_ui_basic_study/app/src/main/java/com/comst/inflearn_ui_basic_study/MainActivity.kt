package com.comst.inflearn_ui_basic_study

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.comst.inflearn_ui_basic_study.ui.theme.Inflearn_ui_basic_studyTheme
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

// https://jsonplaceholder.typicode.com/posts/1
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Inflearn_ui_basic_studyTheme {
                MyDrawer()
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawer() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val screens = listOf(
        Screen.Home,
        Screen.Settings,
        Screen.Phone,
        Screen.Search,
        Screen.Lock,
    )

    val selectedScreen: MutableState<Screen> = remember {
        mutableStateOf(Screen.Home)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "MyDrawer") },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                }
            )
        }
    ) { paddingValues ->
        ModalNavigationDrawer(
            drawerState = drawerState,
            modifier = Modifier.padding(paddingValues),
            drawerContent = {
                ModalDrawerSheet {
                    screens.forEach { screen ->
                        NavigationDrawerItem(
                            icon = { Icon(screen.icon, contentDescription = screen.icon.name) },
                            label = { Text(text = screen.name) },
                            selected = screen == selectedScreen.value,
                            onClick = {
                                scope.launch { drawerState.close() }
                                selectedScreen.value = screen
                            }
                        )
                    }
                }
            },
            content = {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    when( selectedScreen.value){
                        Screen.Home -> HomeScreen()
                        Screen.Settings -> SettingScreen()
                        Screen.Phone -> PhoneScreen()
                        Screen.Search -> SearchScreen()
                        Screen.Lock -> LockScreen()
                    }
                }
            }
        )

    }
}

@Composable
fun HomeScreen() {
    Text(text = "HomeScreen")
}

@Composable
fun SettingScreen() {
    Text(text = "SettingScreen")
}

@Composable
fun PhoneScreen() {
    Text(text = "PhoneScreen")
}

@Composable
fun SearchScreen() {
    Text(text = "SearchScreen")
}

@Composable
fun LockScreen() {
    Text(text = "LockScreen")
}

sealed class Screen(val name: String, val icon: ImageVector) {

    object Home : Screen("Home", Icons.Default.Home)
    object Settings : Screen("Settings", Icons.Default.Settings)
    object Phone : Screen("Phone", Icons.Default.Phone)
    object Search : Screen("Search", Icons.Default.Search)
    object Lock : Screen("Lock", Icons.Default.Lock)

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Inflearn_ui_basic_studyTheme {
        MyDrawer()
    }
}