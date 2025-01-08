package com.example.eco_alpha_test.presentation

import com.example.eco_alpha_test.domain.model.BINDetail
import com.example.eco_alpha_test.presentation.model.BINDetailUI

fun BINDetail.toUI(): BINDetailUI = BINDetailUI(
    latitude = latitude,
    longitude = longitude,
    townName = townName,
    brand = brand,
    city = city,
    name = name,
    phone = phone,
    url = url
)