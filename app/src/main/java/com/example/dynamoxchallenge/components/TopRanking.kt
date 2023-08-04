package com.example.dynamoxchallenge.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dynamoxchallenge.model.UserModel
import com.example.dynamoxchallenge.ui.theme.BronzeColor
import com.example.dynamoxchallenge.ui.theme.CornHarvestColor
import com.example.dynamoxchallenge.ui.theme.DuneColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme
import com.example.dynamoxchallenge.ui.theme.GoldColor
import com.example.dynamoxchallenge.ui.theme.SilverColor

@Composable
fun TopRanking(
    first: UserModel,
    second: UserModel,
    third: UserModel,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier.width(112.dp),
        ) {
            Text(
                text = second.name,
                color = CornHarvestColor,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = second.rightAnswerQuantity.toString(),
                color = CornHarvestColor,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(
                        color = SilverColor,
                        shape = RoundedCornerShape(
                            topStart = 10.dp,
                            topEnd = 10.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    .height(100.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text ="2",
                    color = DuneColor,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )
            }
        }
        Column(
            modifier = Modifier.width(112.dp)
        ) {
            Text(
                text = first.name,
                color = CornHarvestColor,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = first.rightAnswerQuantity.toString(),
                color = CornHarvestColor,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(
                        color = GoldColor,
                        shape = RoundedCornerShape(
                            topStart = 10.dp,
                            topEnd = 10.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text ="1",
                    color = DuneColor,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )
            }
        }
        Column(
            modifier = Modifier.width(112.dp)
        ) {
            Text(
                text = third.name,
                color = CornHarvestColor,
                style = MaterialTheme.typography.titleSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = third.rightAnswerQuantity.toString(),
                color = CornHarvestColor,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(
                        color = BronzeColor,
                        shape = RoundedCornerShape(
                            topStart = 10.dp,
                            topEnd = 10.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    .height(50.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text ="3",
                    color = DuneColor,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopRankingPreview() {
    DynamoxChallengeTheme {
        TopRanking(
            first = UserModel("teste", 2),
            second = UserModel("teste", 2),
            third = UserModel("teste", 2)
        )
    }
}