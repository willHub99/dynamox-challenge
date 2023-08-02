package com.example.dynamoxchallenge.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.dynamoxchallenge.components.CustomLottieAnimation
import com.example.dynamoxchallenge.components.Logo
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun SplashPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo(
            modifier = Modifier
                .width(215.dp)
                .height(160.dp),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(48.dp))
        CustomLottieAnimation(
            resourceId = R.raw.splash_screen,
            modifier = Modifier
                .width(271.dp)
                .height(152.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPagePreview() {
    DynamoxChallengeTheme {
        SplashPage()
    }
}