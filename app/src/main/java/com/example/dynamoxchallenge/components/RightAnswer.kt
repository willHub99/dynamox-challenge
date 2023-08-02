package com.example.dynamoxchallenge.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamoxchallenge.R
import com.example.dynamoxchallenge.constants.RIGHT_ANSWER_MESSAGE
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme
import com.example.dynamoxchallenge.ui.theme.SuccessColor

@Composable
fun RightAnswer() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = RIGHT_ANSWER_MESSAGE,
            color = SuccessColor,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomLottieAnimation(
            resourceId = R.raw.right_answer,
            modifier = Modifier
                .width(173.dp)
                .height(173.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RightAnswerPreview() {
    DynamoxChallengeTheme {
        RightAnswer()
    }
}