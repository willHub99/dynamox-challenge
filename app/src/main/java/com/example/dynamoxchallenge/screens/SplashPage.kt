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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.dynamoxchallenge.R
import com.example.dynamoxchallenge.components.CustomLottieAnimation
import com.example.dynamoxchallenge.components.Logo
import com.example.dynamoxchallenge.navigation.Screen
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun SplashPage(
    navigation: () -> Unit
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId = R.raw.splash_screen)
    )
    val logoAnimationState =
        animateLottieCompositionAsState(composition = composition)
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
        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .width(271.dp)
                .height(152.dp),
            iterations = LottieConstants.IterateForever
        )
    }

    if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
        navigation()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPagePreview() {
    DynamoxChallengeTheme {
        SplashPage(navigation = {})
    }
}