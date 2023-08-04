package com.example.dynamoxchallenge.database


class UserRepository(
    private val userDAO: UserDAO
) {
    suspend fun addUser(user: UserDatabaseModel) {
        userDAO.addUser(user)
    }

    fun getUsersOrderByRightAnswerQuantity(): List<UserDatabaseModel> {
        return userDAO.getUsersOrderByRightAnswerQuantity()
    }

    fun findUser(id: Int): UserDatabaseModel {
        return userDAO.findUser(id = id)
    }

    fun getAllUser(): List<UserDatabaseModel> {
        return userDAO.getAllUsers()
    }

    suspend fun updateUser(user: UserDatabaseModel) {
        userDAO.updateUser(user)
    }

    suspend fun deleteUser(user: UserDatabaseModel) {
        userDAO.deleteUser(user)
    }
}