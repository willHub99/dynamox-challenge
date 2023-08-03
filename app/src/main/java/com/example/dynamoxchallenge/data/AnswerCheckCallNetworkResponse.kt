package com.example.dynamoxchallenge.data

import com.example.dynamoxchallenge.model.AnswerModel

data class AnswerCheckCallNetworkResponse(
    val answer: AnswerModel? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)
