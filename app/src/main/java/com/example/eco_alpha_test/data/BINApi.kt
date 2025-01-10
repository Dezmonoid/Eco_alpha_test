package com.example.eco_alpha_test.data

import com.example.eco_alpha_test.data.model.nw.BINDetailNW
import retrofit2.http.GET
import retrofit2.http.Path

interface BINApi {
    @GET("{bin}")
    suspend fun getCurrentBINData(
        @Path("bin") bin: String
    ): BINDetailNW

}