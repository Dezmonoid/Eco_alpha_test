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
            val bindetail = response.toDomain()
            binDao.insertToDatabase(bindetail.toDB())
            bindetail
        } catch (e: Exception) {
            Log.e("", e.message.toString())
            BINDetail(
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
}