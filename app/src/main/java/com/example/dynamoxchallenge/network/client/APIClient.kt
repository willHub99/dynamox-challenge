package com.example.dynamoxchallenge.network.client

import com.example.dynamoxchallenge.network.interceptor.client
import com.example.dynamoxchallenge.network.model.RequestBody
import com.example.dynamoxchallenge.network.model.Question
import com.example.dynamoxchallenge.network.model.Result
import com.example.dynamoxchallenge.network.service.QuizService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://quiz-api-bwi5hjqyaq-uc.a.run.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val service: QuizService = retrofit.create(QuizService::class.java)

    suspend fun getNewQuestion(): Response<Question> {
        return service.getNewQuestion()
    }

    suspend fun checkAnswer(questionId: Int, answer: RequestBody): Response<Result> {
        return service.checkAnswer(
            questionId = questionId,
            answer = answer
        )
    }
}