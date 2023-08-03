package com.example.dynamoxchallenge.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.dynamoxchallenge.R
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme

@Composable
fun CustomLottieAnimation(
    resourceId: Int,
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId = resourceId)
    )

    LottieAnimation(
        composition = composition,
        modifier = modifier,
        iterations = LottieConstants.IterateForever
    )
}

@Preview(showBackground = true)
@Composable
fun CustomLottieAnimationPreview() {
    DynamoxChallengeTheme {
        CustomLottieAnimation(
            resourceId = R.raw.load_more_question,
            modifier = Modifier.width(271.dp).height(152.dp)
        )
    }
}