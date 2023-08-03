package com.example.dynamoxchallenge.nepositories

import com.example.dynamoxchallenge.network.client.APIClient
import com.example.dynamoxchallenge.network.model.Question
import com.example.dynamoxchallenge.network.model.RequestBody
import com.example.dynamoxchallenge.network.model.Result
import retrofit2.Response

class QuizRepository(
    private val apiClient: APIClient = APIClient()
) {
    suspend fun getNewQuestion(): Response<Question> {
        return apiClient.getNewQuestion()
    }

    suspend fun checkAnswer(questionId: Int, answer: RequestBody): Response<Result> {
        return apiClient.checkAnswer(questionId, answer)
    }
}