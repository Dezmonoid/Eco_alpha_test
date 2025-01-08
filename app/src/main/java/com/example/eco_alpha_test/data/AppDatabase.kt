package com.example.eco_alpha_test.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.eco_alpha_test.data.model.DB.BINDetailDB

@Database(entities = [BINDetailDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun binDao(): BINDetailDAO
}
