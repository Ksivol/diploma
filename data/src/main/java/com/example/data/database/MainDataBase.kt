package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class MainDataBase: RoomDatabase() {

    companion object {
        private var INSTANCE: MainDataBase? = null

        fun getDatabase(context: Context): MainDataBase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context = context,
                    klass = MainDataBase::class.java,
                    "main_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}