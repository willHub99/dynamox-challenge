package com.example.dynamoxchallenge.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamoxchallenge.R
import com.example.dynamoxchallenge.components.CardResult
import com.example.dynamoxchallenge.components.CustomLottieAnimation
import com.example.dynamoxchallenge.components.CustomOutlinedButton
import com.example.dynamoxchallenge.components.Logo
import com.example.dynamoxchallenge.constants.CONGRATULATIONS_MESSAGE
import com.example.dynamoxchallenge.constants.OUTLINED_BUTTON_PLAY_AGAIN_MESSAGE
import com.example.dynamoxchallenge.ui.theme.ButtercupColor
import com.example.dynamoxchallenge.ui.theme.DuneColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun ResultPage(
    name: String,
    qtdRightAnswer: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo(
            modifier = Modifier
                .fillMaxWidth(0.3f),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(48.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Row {
                Text(
                    text = CONGRATULATIONS_MESSAGE,
                    style = MaterialTheme.typography.titleSmall,
                    color = DuneColor
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleSmall,
                    color = ButtercupColor
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomLottieAnimation(
            resourceId = R.raw.congrats,
            modifier = Modifier
                .width(173.dp)
                .height(173.dp)
        )
        Spacer(modifier = Modifier.height(36.dp))
        CardResult(numberActualQuestion = qtdRightAnswer)
        Spacer(modifier = Modifier.height(66.dp))
        CustomOutlinedButton(
            title = OUTLINED_BUTTON_PLAY_AGAIN_MESSAGE,
            modifier = Modifier
                .width(353.dp)
                .height(48.dp),
            action = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPagePreview() {
    DynamoxChallengeTheme {
        ResultPage("Uber", 3)
    }
}