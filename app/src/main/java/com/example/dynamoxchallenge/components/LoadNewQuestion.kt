package com.example.dynamoxchallenge.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamoxchallenge.R
import com.example.dynamoxchallenge.constants.GET_NEW_QUESTION_MESSAGE
import com.example.dynamoxchallenge.ui.theme.DuneColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun LoadNewQuestion() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = GET_NEW_QUESTION_MESSAGE,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = DuneColor
        )
        CustomLottieAnimation(
            resourceId = R.raw.loading,
            modifier = Modifier.width(173.dp).height(130.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadNewQuestionPreview() {
    DynamoxChallengeTheme {
        LoadNewQuestion()
    }
}