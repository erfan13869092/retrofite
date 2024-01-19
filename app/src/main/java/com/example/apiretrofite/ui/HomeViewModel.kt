package com.example.apiretrofite.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiretrofite.data.model.ParentCoinItem
import com.example.apiretrofite.data.repo.RepositoryCoin
import com.example.apiretrofite.util.StateResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val coinRepositoryCoin: RepositoryCoin) : ViewModel() {
    private val _coins: MutableLiveData<StateResponse<List<ParentCoinItem>>> by lazy {
        MutableLiveData<StateResponse<List<ParentCoinItem>>>()
    }
    val coins: LiveData<StateResponse<List<ParentCoinItem>>> by lazy {
        _coins
    }

    init {
        getCoins()
    }

    fun getCoins() {
        viewModelScope.launch {
            coinRepositoryCoin.getCoins().catch {}.collect {
                _coins.value = it
            }
        }
    }
}