package com.example.dynamoxchallenge.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamoxchallenge.constants.BUTTON_TITLE_NEXT_QUESTION_MESSAGE
import com.example.dynamoxchallenge.constants.BUTTON_TITLE_RESULT_MESSAGE
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun CustomButton(
    title: String,
    modifier: Modifier = Modifier,
    action: () -> Unit
) {
    Button(
        modifier = modifier.height(48.dp),
        onClick = { action() },
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    DynamoxChallengeTheme {
        CustomButton(
            title = BUTTON_TITLE_NEXT_QUESTION_MESSAGE,
            action = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview2() {
    DynamoxChallengeTheme {
        CustomButton(
            title = BUTTON_TITLE_RESULT_MESSAGE,
            action = {}
        )
    }
}