package com.example.dynamoxchallenge.navigation

sealed class Screen(val screen: String) {
    object Splash: Screen("splash_screen")
    object Login: Screen("login_page")
    object Question: Screen("question_page")
    object Result: Screen("result_page")
    object Ranking: Screen("ranking_page")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(screen)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
