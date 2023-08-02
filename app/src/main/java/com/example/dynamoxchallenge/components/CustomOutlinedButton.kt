package com.example.dynamoxchallenge.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamoxchallenge.constants.OUTLINED_BUTTON_PLAY_AGAIN_MESSAGE
import com.example.dynamoxchallenge.constants.OUTLINED_BUTTON_PLAY_MESSAGE
import com.example.dynamoxchallenge.ui.theme.CornHarvestColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun CustomOutlinedButton(
    title: String,
    modifier: Modifier = Modifier,
    action: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(2.dp, CornHarvestColor),
        onClick = { action() }
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = CornHarvestColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomOutlinedButtonPreview() {
    DynamoxChallengeTheme {
        CustomOutlinedButton(
            title = OUTLINED_BUTTON_PLAY_MESSAGE,
            modifier = Modifier.width(173.dp).height(48.dp),
            action = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomOutlinedButtonPreview2() {
    DynamoxChallengeTheme {
        CustomOutlinedButton(
            title = OUTLINED_BUTTON_PLAY_AGAIN_MESSAGE,
            modifier = Modifier.width(353.dp).height(48.dp),
            action = {}
        )
    }
}