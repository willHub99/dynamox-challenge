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
import com.example.dynamoxchallenge.constants.ERROR_MESSAGE
import com.example.dynamoxchallenge.constants.TRY_AGAIN_MESSAGE
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme
import com.example.dynamoxchallenge.ui.theme.ErrorColor

@Composable
fun ErrorLoadingNewQuestion(
    action: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = ERROR_MESSAGE,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = ErrorColor
        )
        CustomLottieAnimation(
            resourceId = R.raw.error,
            modifier = Modifier.width(173.dp).height(130.dp)
        )
        CustomOutlinedButton(
            title = TRY_AGAIN_MESSAGE,
            modifier = Modifier
                .width(353.dp)
                .height(48.dp),
            action = {action()}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorLoadingNewQuestionPreview() {
    DynamoxChallengeTheme {
        ErrorLoadingNewQuestion(
            action = {}
        )
    }
}