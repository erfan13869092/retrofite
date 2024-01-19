package com.example.apiretrofite.data.repo

import android.util.Log
import com.example.apiretrofite.data.api.CoinApi
import com.example.apiretrofite.data.model.ParentCoinItem
import com.example.apiretrofite.util.StateResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RepositoryCoinImpl @Inject constructor(private val coinApi: CoinApi) : RepositoryCoin {
    override fun getCoins(): Flow<StateResponse<List<ParentCoinItem>>> = flow {
        Log.d("coinsApi", "thread name->${Thread.currentThread().name}")
        emit(StateResponse.Loading())
        try {
            Log.d("coinsApi", "success->")
            emit(StateResponse.Success(coinApi.getCoins()))
        } catch (e: HttpException) {
            emit(StateResponse.Error("در دریافت اطلاعات با مشکلی روبرو شدیم!!!"))
            Log.d("coinsApi", "error HttpException->${e.message}")
        } catch (e: IOException) {
            emit(StateResponse.Error("لطفا از اتصال خود به اینترنت مطمعن شوید!!!"))
            Log.d("coinsApi", "error IOException->${e.message}")
        }
    }


}