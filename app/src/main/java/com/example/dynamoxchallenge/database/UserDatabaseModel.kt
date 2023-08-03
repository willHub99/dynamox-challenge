package com.example.dynamoxchallenge.database

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Entity(tableName = "users")
data class UserDatabaseModel(
    @PrimaryKey
    var id: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "rightAnswerQuantity")
    var rightAnswerQuantity: Int
)
