package com.example.apiretrofite.data.repo

import com.example.apiretrofite.data.model.ParentCoinItem
import com.example.apiretrofite.util.StateResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface RepositoryCoin {
    fun getCoins():Flow<StateResponse<List<ParentCoinItem>>>
}