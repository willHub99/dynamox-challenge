package com.example.dynamoxchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dynamoxchallenge.screens.LoginPageScreen
import com.example.dynamoxchallenge.screens.QuestionPage
import com.example.dynamoxchallenge.screens.ResultPage
import com.example.dynamoxchallenge.screens.SplashPage

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.screen) {
        composable(route = Screen.Splash.screen) {
            SplashPage()
        }
        composable(route = Screen.Login.screen) {
            LoginPageScreen()
        }
        composable(route = Screen.Question.screen) {
            QuestionPage()
        }
        composable(route = Screen.Result.screen) {
            ResultPage()
        }
    }
}