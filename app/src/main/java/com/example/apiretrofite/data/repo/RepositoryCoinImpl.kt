package com.example.apiretrofite.data.repo

import com.example.apiretrofite.data.api.CoinApi
import com.example.apiretrofite.data.model.ParentCoinItem
import retrofit2.Call
import javax.inject.Inject

class RepositoryCoinImpl @Inject constructor(private val coinApi: CoinApi) : RepositoryCoin {
    override fun getCoins(): Call<List<ParentCoinItem>> = coinApi.getCoins()

}