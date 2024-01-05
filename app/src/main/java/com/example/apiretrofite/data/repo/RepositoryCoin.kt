package com.example.apiretrofite.data.repo

import com.example.apiretrofite.data.model.ParentCoinItem
import retrofit2.Call

interface RepositoryCoin {
    fun getCoins():Call<List<ParentCoinItem>>
}