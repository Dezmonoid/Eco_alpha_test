package com.example.eco_alpha_test.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.eco_alpha_test.data.model.db.BINDetailDB

@Dao
abstract class BINDetailDAO {
    @Query("SELECT * FROM bindetail")
    abstract fun getAll(): List<BINDetailDB>

    @Insert
    abstract fun insert(binDetail: BINDetailDB)
}