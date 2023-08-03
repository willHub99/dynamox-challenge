package com.example.dynamoxchallenge.utils

import com.example.dynamoxchallenge.model.QuestionModel
import com.example.dynamoxchallenge.network.model.Question
import com.example.dynamoxchallenge.network.model.Result
import com.example.dynamoxchallenge.model.AnswerModel
fun Question.convertToQuestionModel(): QuestionModel {
    return QuestionModel(
        id = this.id,
        question = this.statement,
        option = this.option
    )
}

fun Boolean.convertToResultModel(): AnswerModel {
    return AnswerModel(
        result = this
    )
}