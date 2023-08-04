package com.example.dynamoxchallenge.utils

import com.example.dynamoxchallenge.database.UserDatabaseModel
import com.example.dynamoxchallenge.model.QuestionModel
import com.example.dynamoxchallenge.network.model.Question
import com.example.dynamoxchallenge.network.model.Result
import com.example.dynamoxchallenge.model.AnswerModel
import com.example.dynamoxchallenge.model.UserModel

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

fun List<UserDatabaseModel>.convertToUserModel(): List<UserModel> {
    val users  = mutableListOf<UserModel>()
    for(user in this) {
       users.add(
           UserModel(
               name = user.name,
               rightAnswerQuantity = user.rightAnswerQuantity
           )
       )
    }
    return users
}