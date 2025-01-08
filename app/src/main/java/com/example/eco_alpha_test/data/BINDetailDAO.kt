package com.example.eco_alpha_test.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.eco_alpha_test.data.model.DB.BINDetailDB

@Dao
abstract class BINDetailDAO {
    @Query("SELECT * FROM bindetail")
    abstract fun getAll(): LiveData<List<BINDetailDB>>

    @Query("DELETE FROM bindetail")
    abstract fun deleteAll()

    @Insert
    abstract fun insert(bindetail: BINDetailDB)

    @Transaction
    open fun insertToDatabase(bindetail: BINDetailDB) {
        deleteAll()
        insert(bindetail)
    }
}