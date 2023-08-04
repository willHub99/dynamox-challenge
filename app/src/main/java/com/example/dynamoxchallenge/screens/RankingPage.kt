package com.example.dynamoxchallenge.screens



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dynamoxchallenge.R
import com.example.dynamoxchallenge.components.CustomButton
import com.example.dynamoxchallenge.components.CustomLottieAnimation
import com.example.dynamoxchallenge.components.Logo
import com.example.dynamoxchallenge.components.TopRanking
import com.example.dynamoxchallenge.constants.BACK_MESSAGE
import com.example.dynamoxchallenge.constants.DEFAULT_RANKING_PAGE_MESSAGE
import com.example.dynamoxchallenge.constants.RANKINK_MESSAGE
import com.example.dynamoxchallenge.data.UserListState
import com.example.dynamoxchallenge.database.UserRoomDatabase
import com.example.dynamoxchallenge.ui.theme.DuneColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme
import com.example.dynamoxchallenge.viewmodels.DatabaseViewModel

@Composable
fun RankingPage(
    navigation: () -> Unit
) {
    val database: UserRoomDatabase = UserRoomDatabase.getInstance(LocalContext.current)
    val viewModel: DatabaseViewModel = viewModel { DatabaseViewModel(database) }
    val usersState: UserListState by viewModel.users.collectAsState()

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
    ) {


        usersState.users?.let {ranking ->
            if (ranking.size > 3) {
                LazyColumn() {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 36.dp)
                            ,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Logo(
                                modifier = Modifier
                                    .fillMaxWidth(0.3f)
                                    .clickable {
                                        navigation()
                                    },
                                style = MaterialTheme.typography.titleMedium
                            )
                            CustomLottieAnimation(
                                resourceId = R.raw.splash_screen,
                                modifier = Modifier
                                    .width(121.dp)
                                    .height(68.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(36.dp))
                    }
                    item {
                        Text(
                            text = RANKINK_MESSAGE,
                            color = DuneColor,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                    item {
                        TopRanking(
                            first = ranking[0],
                            second = ranking[1],
                            third = ranking[2]
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    items(ranking.subList(3, ranking.size)) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                                .padding(bottom = 8.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = it.name,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(end = 36.dp)
                                )
                                Text(
                                    text = it.rightAnswerQuantity.toString(),
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                        CustomButton(
                            title = BACK_MESSAGE,
                        ) {
                            navigation()
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            } else {
                Text(
                    text = DEFAULT_RANKING_PAGE_MESSAGE,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RankingPagePreview() {
    DynamoxChallengeTheme {
        RankingPage(
            navigation = {}
        )
    }
}