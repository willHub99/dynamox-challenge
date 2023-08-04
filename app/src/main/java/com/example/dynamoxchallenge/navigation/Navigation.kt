package com.example.dynamoxchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dynamoxchallenge.screens.LoginPageScreen
import com.example.dynamoxchallenge.screens.QuestionPage
import com.example.dynamoxchallenge.screens.RankingPage
import com.example.dynamoxchallenge.screens.ResultPage
import com.example.dynamoxchallenge.screens.SplashPage

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.screen) {
        composable(route = Screen.Splash.screen) {
            SplashPage { navController.navigate(Screen.Login.screen) }
        }
        composable(route = Screen.Login.screen) {
            LoginPageScreen(navController)
        }
        composable(route = Screen.Ranking.screen) {
            RankingPage(
                navigation = {navController.navigate(Screen.Login.screen)}
            )
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
                QuestionPage(name = name, navController)
            }
        }
        composable(
            route = Screen.Result.screen + "/{name}" + "/{qtdRightAnswer}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                },
                navArgument(name = "qtdRightAnswer") {
                    type = NavType.StringType
                }
            )
        ) {entry ->
            val nome = entry.arguments?.getString("name")
            val qtdRightAnswer = entry.arguments?.getString("qtdRightAnswer")
            qtdRightAnswer?.let {qtd ->
                nome?.let {name ->
                    ResultPage(
                        name = name,
                        qtdRightAnswer = qtd.toInt(),
                        navigation = {navController.navigate(Screen.Login.screen)}
                    )
                }
            }
        }
    }
}