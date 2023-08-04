package com.example.dynamoxchallenge.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserDatabaseModel)
    @Query("SELECT * FROM users WHERE id = :id")
    fun findUser(id: Int): UserDatabaseModel
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserDatabaseModel>
    @Update
    suspend fun updateUser(user: UserDatabaseModel)
    @Delete
    suspend fun deleteUser(user: UserDatabaseModel)
    @Query("SELECT * FROM users ORDER BY rightAnswerQuantity DESC")
    fun getUsersOrderByRightAnswerQuantity(): List<UserDatabaseModel>
}