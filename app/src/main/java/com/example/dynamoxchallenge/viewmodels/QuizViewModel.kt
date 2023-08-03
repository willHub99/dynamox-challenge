package com.example.dynamoxchallenge.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamoxchallenge.data.AnswerCheckCallNetworkResponse
import com.example.dynamoxchallenge.data.QuestionCallNetworkState
import com.example.dynamoxchallenge.data.StateGame
import com.example.dynamoxchallenge.nepositories.QuizRepository
import com.example.dynamoxchallenge.network.model.RequestBody
import com.example.dynamoxchallenge.utils.convertToQuestionModel
import com.example.dynamoxchallenge.utils.convertToResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QuizViewModel(
    private val repository: QuizRepository = QuizRepository()
): ViewModel() {

    private val _questionPage = MutableStateFlow(QuestionCallNetworkState())
    val questionState = _questionPage.asStateFlow()

    private val _answerState = MutableStateFlow(AnswerCheckCallNetworkResponse())
    val answerState = _answerState.asStateFlow()

    private val _stateGame = MutableStateFlow(StateGame())
    val stateGame = _stateGame.asStateFlow()
    init {
        getNewQuestion()
    }

    fun getNewQuestion() = viewModelScope.launch(Dispatchers.IO) {
        _questionPage.update {
            it.copy(
                isLoading = true,
                error = ""
            )
        }
        try {
            val response = repository.getNewQuestion()
            if (response.isSuccessful) {
                _questionPage.update {
                    it.copy(
                        isLoading = false,
                        error = "",
                        question = response.body()?.convertToQuestionModel()
                    )
                }
                _stateGame.update {
                    it.copy(
                        actualQuestion = it.actualQuestion + 1,
                        isLastQuestion = (it.actualQuestion + 1) == 10
                    )
                }
            }
        } catch (e: Exception) {
            _questionPage.update {
                it.copy(
                    isLoading = false,
                    error = e.message.toString()
                )
            }
        }
    }

    fun checkAnswer(questionId: Int, answer: String) = viewModelScope.launch(Dispatchers.IO) {
        _answerState.update {
            it.copy(
                isLoading = true,
                error = ""
            )

        }
        try {
            val answer: RequestBody = RequestBody(answer = answer)
            val response = repository.checkAnswer(questionId, answer)
            if (response.isSuccessful) {
                _answerState.update {
                    it.copy(
                        isLoading = false,
                        error = "",
                        answer = response.body()?.result?.convertToResultModel()
                    )
                }
                response.body()?.result?.let { isRightAnswer ->
                    if (isRightAnswer) {
                        _stateGame.update {
                            it.copy(
                                numberRightAnswer = it.numberRightAnswer + 1
                            )
                        }
                    }
                }
            }
        } catch (e: Exception) {
            _questionPage.update {
                it.copy(
                    isLoading = false,
                    error = e.message.toString()
                )
            }
        }
    }

}