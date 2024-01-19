package com.example.apiretrofite.data.api

import com.example.apiretrofite.data.model.ParentCoinItem
import retrofit2.Call
import retrofit2.http.GET

interface CoinApi {
    @GET("coins/list")
    suspend fun getCoins(): List<ParentCoinItem>
}