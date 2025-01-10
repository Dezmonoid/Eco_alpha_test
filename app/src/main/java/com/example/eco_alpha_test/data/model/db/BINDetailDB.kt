package com.example.eco_alpha_test.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bindetail")
data class BINDetailDB(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "bin")
    val bin: String = "",
    @ColumnInfo(name = "lt")
    val latitude: Int?,
    @ColumnInfo(name = "ln")
    val longitude: Int?,
    @ColumnInfo(name = "tname")
    val townName: String?,
    @ColumnInfo(name = "brand")
    val brand: String?,
    @ColumnInfo(name = "city")
    val city: String?,
    @ColumnInfo(name = "bname")
    val name: String?,
    @ColumnInfo(name = "phone")
    val phone: String?,
    @ColumnInfo(name = "url")
    val url: String?
)