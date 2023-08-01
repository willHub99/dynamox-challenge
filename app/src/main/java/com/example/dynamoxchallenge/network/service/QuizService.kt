package com.example.dynamoxchallenge.network.service

import com.example.dynamoxchallenge.network.model.RequestBody
import com.example.dynamoxchallenge.network.model.Question
import com.example.dynamoxchallenge.network.model.Result
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface QuizService {
    @GET("question")
    suspend fun getNewQuestion(): Response<Question>;

    @Headers("content-type:application/json")
    @POST("answer")
    suspend fun checkAnswer(@Query("questionId") questionId: Int, @Body answer: RequestBody): Response<Result>
}