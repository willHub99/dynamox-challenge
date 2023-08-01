package com.example.dynamoxchallenge.database

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(
    private val userDAO: UserDAO,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val coroutineScope = CoroutineScope(dispatcher)
    fun addUser(user: UserDatabaseModel) {
        coroutineScope.launch {
            userDAO.addUser(user)
        }
    }

    fun findUser(id: Int): UserDatabaseModel {
        return userDAO.findUser(id = id)
    }

    fun getAllUser(): List<UserDatabaseModel> {
        return userDAO.getAllUsers()
    }

    fun updateUser(user: UserDatabaseModel) {
        coroutineScope.launch {
            userDAO.updateUser(user)
        }
    }

    fun deleteUser(user: UserDatabaseModel) {
        coroutineScope.launch {
            userDAO.deleteUser(user)
        }
    }
}