package com.comst.graphapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.comst.graphapp.screen.Graph1
import com.comst.graphapp.screen.Graph2
import com.comst.graphapp.screen.Graph3
import com.comst.graphapp.ui.theme.GraphAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphAppTheme {
                // A surface container using the 'background' color from the theme
                GraphAppMain()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GraphAppMain() {

    val navController = rememberNavController()

    val navItems = listOf(
        NavigationItem("그래프1", Icons.Default.AddCircle, "tab1"),
        NavigationItem("그래프2", Icons.Default.AddCircle, "tab2"),
        NavigationItem("그래프3", Icons.Default.AddCircle, "tab3"),
    )

    Scaffold(
        bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    navItems.forEach { nav ->

                        val currentRoute =
                            navController.currentBackStackEntryAsState().value?.destination?.route
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.clickable {
                                navController.navigate(nav.route)
                            }
                        ) {

                            // True -> 현재 클릭된 탭
                            // False -> 현재 클릭되지 않은 탭
                            val isCurrentRoute = nav.route == currentRoute

                            Icon(
                                imageVector = nav.icon,
                                contentDescription = nav.name,
                                tint = if (isCurrentRoute) Color.Red else Color.Black
                            )
                            Text(
                                text = nav.name,
                                color = if (isCurrentRoute) Color.Red else Color.Black
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
//        Box(modifier = Modifier.padding(paddingValues)) {
//            Text(text = "임시 텍스트")
//        }

        NavHost(
            navController = navController,
            startDestination = navItems.first().route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("tab1") {
                Graph1()
            }

            composable("tab2") {
                Graph2()
            }

            composable("tab3") {
                Graph3()
            }
        }
    }

}

data class NavigationItem(

    val name: String,
    val icon: ImageVector,
    val route: String
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GraphAppTheme {
        GraphAppMain()
    }
}