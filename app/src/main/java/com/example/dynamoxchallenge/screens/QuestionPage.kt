package com.example.dynamoxchallenge.screens

import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dynamoxchallenge.R
import com.example.dynamoxchallenge.components.CardQuestion
import com.example.dynamoxchallenge.components.CustomAppBar
import com.example.dynamoxchallenge.components.CustomButton
import com.example.dynamoxchallenge.components.CustomLottieAnimation
import com.example.dynamoxchallenge.components.ErrorLoadingNewQuestion
import com.example.dynamoxchallenge.components.LoadNewQuestion
import com.example.dynamoxchallenge.components.RightAnswer
import com.example.dynamoxchallenge.components.WrongAnswer
import com.example.dynamoxchallenge.constants.ALTERNATIVE_MESSAGE
import com.example.dynamoxchallenge.constants.BUTTON_TITLE_NEXT_QUESTION_MESSAGE
import com.example.dynamoxchallenge.constants.BUTTON_TITLE_RESULT_MESSAGE
import com.example.dynamoxchallenge.constants.CHECK_ANSWER_MESSAGE
import com.example.dynamoxchallenge.data.AnswerCheckCallNetworkResponse
import com.example.dynamoxchallenge.data.QuestionCallNetworkState
import com.example.dynamoxchallenge.data.StateGame
import com.example.dynamoxchallenge.navigation.Screen
import com.example.dynamoxchallenge.ui.theme.ButtercupColor
import com.example.dynamoxchallenge.ui.theme.CornHarvestColor
import com.example.dynamoxchallenge.ui.theme.DuneColor
import com.example.dynamoxchallenge.ui.theme.DynamoxChallengeTheme
import com.example.dynamoxchallenge.ui.theme.WestarColor
import com.example.dynamoxchallenge.viewmodels.QuizViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionPage(
    name: String,
    navController: NavController
) {
    val viewModel: QuizViewModel = viewModel { QuizViewModel() }

    val question: QuestionCallNetworkState by viewModel.questionState.collectAsState()
    val answerState: AnswerCheckCallNetworkResponse by viewModel.answerState.collectAsState()
    val stateGame: StateGame by viewModel.stateGame.collectAsState()

    var selectedQuestion by rememberSaveable {
        mutableStateOf("")
    }

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    var showModal by rememberSaveable {
        mutableStateOf(false)
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = if (showModal) 400.dp else 0.dp,
        sheetContainerColor = Color.White,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (answerState.isLoading) {
                    CustomLottieAnimation(
                        resourceId = R.raw.load_more_question,
                        modifier = Modifier
                            .width(173.dp)
                            .height(130.dp)
                    )
                } else {
                    answerState.answer?.let { answerModel ->
                        if (answerModel.result) {
                            RightAnswer()
                        } else {
                            WrongAnswer()
                        }
                        Spacer(modifier = Modifier.height(48.dp))
                        if (!stateGame.isLastQuestion) {
                            CustomButton(
                                title = BUTTON_TITLE_NEXT_QUESTION_MESSAGE,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                showModal = false
                                viewModel.getNewQuestion()
                            }
                        } else {
                            CustomButton(
                                title = BUTTON_TITLE_RESULT_MESSAGE,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                navController.navigate(
                                    Screen.Result.withArgs(
                                        name,
                                        stateGame.numberRightAnswer.toString()
                                    )
                                )
                            }
                        }
                    }
                }
                if (answerState.error.isNotEmpty()) {
                    ErrorLoadingNewQuestion {
                        question.question?.let { question ->
                            viewModel.checkAnswer(
                                questionId = question.id.toInt(),
                                answer = selectedQuestion
                            )
                        }
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .clickable {
                    showModal = false
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomAppBar(name = name)
            Spacer(modifier = Modifier.height(24.dp))
            if (question.isLoading) {
                LoadNewQuestion()
            } else {
                question.question?.let { question ->
                    val (selectedOption, onOptionSelected) = remember { mutableStateOf(question.option[0]) }
                    LazyColumn() {
                        item {
                            CardQuestion(
                                question = question.question,
                                numberActualQuestion = stateGame.actualQuestion,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                        }
                        item {
                            Text(
                                text = ALTERNATIVE_MESSAGE,
                                style = MaterialTheme.typography.bodyMedium,
                                color = DuneColor,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                        }
                        items(question.option) {
                            Row(
                                modifier = Modifier
                                    .selectableGroup()
                                    .selectable(
                                        selected = (it == selectedOption),
                                        onClick = {
                                            onOptionSelected(it)
                                            selectedQuestion = it
                                        }
                                    )
                                    .fillMaxWidth()
                                    .height(64.dp)
                                    .background(
                                        color = if (it == selectedOption) ButtercupColor else WestarColor,
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = it,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = if (it == selectedOption) Color.White else DuneColor ,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth()
                                )
                                RadioButton(
                                    selected = (it == selectedOption),
                                    onClick = null,
                                    modifier = Modifier
                                        .semantics { contentDescription = "question alternative" },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.Transparent,
                                        unselectedColor = Color.Transparent,
                                        disabledSelectedColor = Color.Transparent,
                                        disabledUnselectedColor = Color.Transparent
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                        item {
                            Text(
                                text = CHECK_ANSWER_MESSAGE,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center,
                                color = CornHarvestColor,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(64.dp)
                                    .padding(
                                        top = 16.dp,
                                        bottom = 16.dp
                                    )
                                    .clickable {
                                        if (selectedQuestion.isNotEmpty()) {
                                            viewModel.checkAnswer(
                                                questionId = question.id.toInt(),
                                                answer = selectedQuestion
                                            )
                                        }
                                        showModal = true
                                        coroutineScope.launch { scaffoldState.bottomSheetState.expand() }
                                    }
                            )
                        }
                    }
                }

            }
            if (question.error.isNotEmpty()) {
                ErrorLoadingNewQuestion {
                    viewModel.getNewQuestion()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionPagePreview() {
    DynamoxChallengeTheme {
        QuestionPage(
            name = "Uber",
            navController = NavController(LocalContext.current)
        )
    }
}