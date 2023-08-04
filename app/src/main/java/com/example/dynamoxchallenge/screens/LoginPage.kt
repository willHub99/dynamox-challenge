package com.example.dynamoxchallenge.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dynamoxchallenge.R
import com.example.dynamoxchallenge.components.CustomLottieAnimation
import com.example.dynamoxchallenge.components.CustomOutlinedButton
import com.example.dynamoxchallenge.components.Logo
import com.example.dynamoxchallenge.components.TopRanking
import com.example.dynamoxchallenge.constants.OUTLINED_BUTTON_PLAY_MESSAGE
import com.example.dynamoxchallenge.constants.TEXT_FIELD_MESSAGE
import com.example.dynamoxchallenge.data.UserListState
import com.example.dynamoxchallenge.database.UserRoomDatabase
import com.example.dynamoxchallenge.navigation.Screen
import com.example.dynamoxchallenge.ui.theme.ButtercupColor
import com.example.dynamoxchallenge.ui.theme.CardColor
import com.example.dynamoxchallenge.ui.theme.DuneColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme
import com.example.dynamoxchallenge.ui.theme.WestarColor
import com.example.dynamoxchallenge.viewmodels.DatabaseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPageScreen(
    navController: NavController
) {
    var text by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 65.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Logo(
                modifier = Modifier
                    .fillMaxWidth(0.3f),
                style = MaterialTheme.typography.titleMedium
            )
            CustomLottieAnimation(
                resourceId = R.raw.splash_screen,
                modifier = Modifier
                    .width(121.dp)
                    .height(68.dp)
            )
        }
        Spacer(modifier = Modifier.height(164.dp))
        TextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(
                    text = TEXT_FIELD_MESSAGE,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                ) },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedContainerColor = ButtercupColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.background(
                color = CardColor,
                shape = RoundedCornerShape(10.dp)
            )
                .height(64.dp)
        )
        Spacer(modifier = Modifier.height(36.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomOutlinedButton(
                title = OUTLINED_BUTTON_PLAY_MESSAGE,
                modifier = Modifier
                    .width(263.dp)
                    .height(48.dp),
                action = {
                    if (text.isNotEmpty()) {
                        navController.navigate(Screen.Question.withArgs(text))
                    }
                }
            )
            Image(
                painter = painterResource(id = R.drawable.ranking),
                contentDescription = "ranking image",
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .clickable {
                        navController.navigate(Screen.Ranking.screen)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPageScreenPreview() {
    DynamoxChallengeTheme {
        LoginPageScreen(navController = NavController(LocalContext.current))
    }
}