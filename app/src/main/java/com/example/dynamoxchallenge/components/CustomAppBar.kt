package com.example.dynamoxchallenge.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamoxchallenge.constants.WELCOME_MESSAGE
import com.example.dynamoxchallenge.ui.theme.ButtercupColor
import com.example.dynamoxchallenge.ui.theme.DuneColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun CustomAppBar(
    name: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(112.dp)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Logo(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .fillMaxHeight(),
            style = MaterialTheme.typography.titleMedium
        )
        Row {
            Text(
                text = WELCOME_MESSAGE,
                style = MaterialTheme.typography.bodyLarge,
                color = DuneColor
            )
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge,
                color = ButtercupColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomAppBarPreview() {
    DynamoxChallengeTheme {
        CustomAppBar(name = "Uber")
    }
}