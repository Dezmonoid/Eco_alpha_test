package com.example.eco_alpha_test.domain

import com.example.eco_alpha_test.domain.model.BINDetail

interface BINRepository {
    suspend fun getBINDetail(bin:String): BINDetail
    suspend fun getHistoryBINDetail(): List<BINDetail>
}