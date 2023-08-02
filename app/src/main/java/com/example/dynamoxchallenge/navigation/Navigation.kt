package com.example.dynamoxchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(
            route = Screen.Question.screen + "/{name}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                }
            )
        ) {entry ->
            entry.arguments?.getString("name")?.let {name ->
                QuestionPage(name = name)
            }
        }
        composable(
            route = Screen.Result.screen + "/{name}" + "/{qtdRightAnswer}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                },
                navArgument(name = "qtdRightAnswer") {
                    type = NavType.IntType
                }
            )
        ) {entry ->
            val nome = entry.arguments?.getString("name")
            val qtdRightAnswer = entry.arguments?.getInt("qtdRightAnswer")
            qtdRightAnswer?.let {qtd ->
                nome?.let {name ->
                    ResultPage(
                        name = name,
                        qtdRightAnswer = qtd
                    )
                }

            }
        }
    }
}