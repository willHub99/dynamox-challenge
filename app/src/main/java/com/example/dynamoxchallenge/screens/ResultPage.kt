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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dynamoxchallenge.R
import com.example.dynamoxchallenge.components.CardResult
import com.example.dynamoxchallenge.components.CustomLottieAnimation
import com.example.dynamoxchallenge.components.CustomOutlinedButton
import com.example.dynamoxchallenge.components.Logo
import com.example.dynamoxchallenge.constants.CONGRATULATIONS_MESSAGE
import com.example.dynamoxchallenge.constants.OUTLINED_BUTTON_PLAY_AGAIN_MESSAGE
import com.example.dynamoxchallenge.database.UserDatabaseModel
import com.example.dynamoxchallenge.database.UserRoomDatabase
import com.example.dynamoxchallenge.ui.theme.ButtercupColor
import com.example.dynamoxchallenge.ui.theme.DuneColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme
import com.example.dynamoxchallenge.viewmodels.DatabaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

@Composable
fun ResultPage(
    name: String,
    qtdRightAnswer: Int,
    navigation: () -> Unit
) {
    val database: UserRoomDatabase = UserRoomDatabase.getInstance(LocalContext.current)
    val viewModel: DatabaseViewModel = DatabaseViewModel(database)
    LaunchedEffect(key1 = true) {
        viewModel.saveUser(name = name, qtdRightAnswer = qtdRightAnswer)
    }
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
            action = {
                navigation()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPagePreview() {
    DynamoxChallengeTheme {
        ResultPage("Uber", 3, navigation = {})
    }
}