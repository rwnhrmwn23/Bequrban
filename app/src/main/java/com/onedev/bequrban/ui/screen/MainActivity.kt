package com.onedev.bequrban.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.onedev.bequrban.ui.screen.detail.DetailScreen
import com.onedev.bequrban.ui.screen.home.HomeScreen
import com.onedev.bequrban.ui.screen.login.LoginScreen
import com.onedev.bequrban.ui.screen.ui.theme.BequrbanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BequrbanTheme {
                MyApp()
            }
        }
    }
}

sealed class Screen {
    object Login : Screen()
    object Home : Screen()
    object Detail : Screen()
}

@Composable
fun MyApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Login) }

    when (currentScreen) {
        is Screen.Login -> LoginScreen(onNavigateToHome = { currentScreen = Screen.Home })
        is Screen.Home -> HomeScreen(onNavigateToDetail = { currentScreen = Screen.Detail })
        is Screen.Detail -> DetailScreen(onBack = { currentScreen = Screen.Home })
    }
}