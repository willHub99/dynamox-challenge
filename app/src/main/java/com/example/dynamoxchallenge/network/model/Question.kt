package com.example.dynamoxchallenge.network.model

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("id")
    val id: String,
    @SerializedName("statement")
    val statement: String,
    @SerializedName("options")
    val option: List<String>
)
