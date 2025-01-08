package com.example.eco_alpha_test.data

import com.example.eco_alpha_test.data.model.DB.BINDetailDB
import com.example.eco_alpha_test.data.model.NW.BINDetailNW
import com.example.eco_alpha_test.domain.model.BINDetail

fun BINDetailNW.toDomain(): BINDetail = BINDetail(
    latitude = country?.latitude.toZeroIfNull(),
    longitude = country?.longitude.toZeroIfNull(),
    townName = country?.name.toString(),
    brand = brand.toString(),
    city = bank?.city.toString(),
    name = bank?.name.toString(),
    phone = bank?.phone.toString(),
    url = bank?.url.toString()
)

fun BINDetailDB.toDomain(): BINDetail = BINDetail(
    latitude = latitude.toZeroIfNull(),
    longitude = longitude.toZeroIfNull(),
    townName = townName.toString(),
    brand = brand.toString(),
    city = city.toString(),
    name = name.toString(),
    phone = phone.toString(),
    url = url.toString()
)

fun BINDetail.toDB(): BINDetailDB = BINDetailDB(
    latitude = latitude,
    longitude = longitude,
    townName = townName,
    brand = brand,
    city = city,
    name = name,
    phone = phone,
    url = url
)

fun Int?.toZeroIfNull(): Int = this ?: 0