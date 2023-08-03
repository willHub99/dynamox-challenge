package com.example.dynamoxchallenge.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamoxchallenge.database.UserDatabaseModel
import com.example.dynamoxchallenge.database.UserRepository
import com.example.dynamoxchallenge.database.UserRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

class DatabaseViewModel(
    private val database: UserRoomDatabase
): ViewModel() {
    private val repository: UserRepository = UserRepository(database.userDao())

    fun saveUser(name: String, qtdRightAnswer: Int) = viewModelScope.launch(Dispatchers.IO) {
        val user = UserDatabaseModel(
            id = UUID.randomUUID().toString(),
            name = name,
            rightAnswerQuantity = qtdRightAnswer
        )
        repository.addUser(user)
    }
}