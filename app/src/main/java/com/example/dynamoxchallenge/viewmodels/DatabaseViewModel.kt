package com.example.dynamoxchallenge.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamoxchallenge.data.UserListState
import com.example.dynamoxchallenge.database.UserDatabaseModel
import com.example.dynamoxchallenge.database.UserRepository
import com.example.dynamoxchallenge.database.UserRoomDatabase
import com.example.dynamoxchallenge.model.UserModel
import com.example.dynamoxchallenge.utils.convertToUserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class DatabaseViewModel(
    private val database: UserRoomDatabase
): ViewModel() {
    private val repository: UserRepository = UserRepository(database.userDao())

    private val _users = MutableStateFlow(UserListState())
    val users = _users.asStateFlow()

    init {
        getUsersOrderByRightAnswerQuantity()
    }

    fun saveUser(name: String, qtdRightAnswer: Int) = viewModelScope.launch(Dispatchers.IO) {
        val user = UserDatabaseModel(
            id = UUID.randomUUID().toString(),
            name = name,
            rightAnswerQuantity = qtdRightAnswer
        )
        repository.addUser(user)
    }

    fun getUsersOrderByRightAnswerQuantity() = viewModelScope.launch(Dispatchers.IO) {
        val listUserDatabaseModel: List<UserDatabaseModel> = repository.getUsersOrderByRightAnswerQuantity()
        _users.update {
            it.copy(
                users = listUserDatabaseModel.convertToUserModel()
            )
        }
    }
}