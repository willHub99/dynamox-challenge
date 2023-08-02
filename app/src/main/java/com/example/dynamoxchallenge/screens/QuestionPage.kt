package com.example.dynamoxchallenge.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamoxchallenge.components.CustomAppBar
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun QuestionPage(
    name: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        CustomAppBar(name = name)
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionPagePreview() {
    DynamoxChallengeTheme {
        QuestionPage(
            name = "Uber"
        )
    }
}