package com.example.dynamoxchallenge.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dynamoxchallenge.constants.TABLE_NAME
import kotlinx.parcelize.Parcelize
@Parcelize
@Entity(tableName = TABLE_NAME)
data class UserDatabaseModel(
    @PrimaryKey
    var id: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "rightAnswerQuantity")
    var rightAnswerQuantity: Int
): Parcelable
