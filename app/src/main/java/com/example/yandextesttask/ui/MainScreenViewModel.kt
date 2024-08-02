package com.example.yandextesttask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yandextesttask.data.api.KtorfitApi
import com.example.yandextesttask.data.models.RickResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val ktorApi: KtorfitApi
) : ViewModel() {

    private val _offers = MutableStateFlow(RickResponse("", "", ""))
    val offers get() = _offers

    fun fetchData() {
        viewModelScope.launch {
            val a = ktorApi.fetchData()
            println("****" + a)
            _offers.value = a
        }
    }
    fun updetaDataFromService(serviceMsg:String){
        _offers.value.episodes= serviceMsg

    }
}