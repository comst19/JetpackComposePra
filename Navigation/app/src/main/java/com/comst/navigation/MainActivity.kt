package com.comst.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.comst.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNav()
                }
            }
        }
    }
}

@Composable
fun MyNav(
    modifier : Modifier = Modifier,
    navController : NavHostController = rememberNavController()
){
    
    NavHost(navController, "Home", modifier = modifier){
        composable("Home"){
            Column() {
                Text(text = "Home")
                Button(onClick = {
                    navController.navigate("Office"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                    }
                }) {
                    Text(text = "Office로 이동")
                }
                Button(onClick = {
                    navController.navigate("Playground"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                    }
                }) {
                    Text(text = "Playgrond로 이동")
                }
                Button(onClick = {
                    navController.navigate("Home"){
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "Home 이동")
                }
                Button(onClick = {
                    navController.navigate("Argument/fastcampus"){
                        launchSingleTop = true
                    }
                }) {
                    Text(text = "fastcampus 아이디로 연결")
                }
            }
        }

        composable("Office"){
            Column() {
                Text(text = "Office")
                Button(onClick = {
                    navController.navigate("Home"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                    }
                }) {
                    Text(text = "Home으로 이동")
                }
                Button(onClick = {
                    navController.navigate("Playground"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                    }
                }) {
                    Text(text = "Playgrond로 이동")
                }
            }
        }

        composable("Playground"){
            Column() {
                Text(text = "Playground")
                Button(onClick = {
                    navController.navigate("Home"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                    }
                }) {
                    Text(text = "Home으로 이동")
                }
                Button(onClick = {
                    navController.navigate("Office"){
                        popUpTo("Home"){
                            inclusive = true
                        }
                    }
                }) {
                    Text(text = "Office로 이동")
                }
            }
        }

        composable("Argument/{userId}"){ backStackEntry ->
            val userId = backStackEntry.arguments?.get("userId")
            Text(text = "userId : $userId")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationTheme {

    }
}