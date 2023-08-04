package com.example.dynamoxchallenge.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dynamoxchallenge.constants.TABLE_NAME

@Database(entities = [(UserDatabaseModel::class)], version = 1, exportSchema = false)
abstract class UserRoomDatabase: RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getInstance(context: Context): UserRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserRoomDatabase::class.java,
                        TABLE_NAME
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}