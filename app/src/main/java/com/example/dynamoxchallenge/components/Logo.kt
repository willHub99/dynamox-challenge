package com.example.dynamoxchallenge.components

import android.media.tv.TvContract.Channels.Logo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamoxchallenge.constants.ASK_WORD
import com.example.dynamoxchallenge.constants.ME_WORK
import com.example.dynamoxchallenge.ui.theme.ButtercupColor
import com.example.dynamoxchallenge.ui.theme.DuneColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun Logo(
    modifier: Modifier = Modifier,
    style: TextStyle
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = ASK_WORD,
            color = DuneColor,
            style = style,
        )
        Text(
            text = ME_WORK,
            color = ButtercupColor,
            style = style,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LogoPreview() {
    DynamoxChallengeTheme{
        Logo(
            modifier = Modifier.width(215.dp).height(160.dp),
            style = MaterialTheme.typography.titleLarge
        )
    }
}