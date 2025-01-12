package com.example.eco_alpha_test.data

import android.util.Log
import com.example.eco_alpha_test.domain.BINRepository
import com.example.eco_alpha_test.domain.model.BINDetail

class BINRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val binApi: BINApi,
) : BINRepository {
    private val binDao = appDatabase.binDao()
    override suspend fun getBINDetail(bin: String): BINDetail {
        return try {
            val response = binApi.getCurrentBINData(
                bin = bin
            )
            val binDetail = response.toDomain(bin)
            binDao.insert(binDetail.toDB())
            binDetail
        } catch (e: Exception) {
            //Log.e("", e.message.toString())
            BINDetail(
                bin = bin,
                latitude = 0,
                longitude = 0,
                townName = "",
                brand = "",
                city = "",
                name = "",
                phone = "",
                url = ""
            )
        }
    }

    override suspend fun getHistoryBINDetail(): List<BINDetail> {
        return binDao.getAll().map { it.toDomain() }
    }
}