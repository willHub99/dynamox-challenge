package com.example.dynamoxchallenge.data

import com.example.dynamoxchallenge.model.QuestionModel
import com.example.dynamoxchallenge.network.model.Question

data class QuestionCallNetworkState(
   val question: QuestionModel? = null,
   val isLoading: Boolean = false,
   val error: String = ""
)
