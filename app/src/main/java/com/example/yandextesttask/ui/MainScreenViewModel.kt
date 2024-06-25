package com.example.yandextesttask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yandextesttask.data.models.Response
import com.example.yandextesttask.data.retrofit.RetrofitRepository
import com.example.yandextesttask.repository.KtorfitRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainScreenViewModel() : ViewModel(), KoinComponent {

//    val repo by inject<RetrofitRepository>()
    val ktorRepo:KtorfitRepository by inject<KtorfitRepository>()
   private val _offers = MutableStateFlow<Response>(Response(emptyList()))
    val offers get() = _offers


    //    fun fakeData(): String {
//        return fakerepo.fakeData()
//    }
//
//    fun fetchData() {
//      viewModelScope.launch {
//            val a=repository.fetchData()
//          println("****"+a)
//        }
//    }
    fun fetchData() {
        viewModelScope.launch {
            val a = ktorRepo.fetchData()
            _offers.value = a
        }
    }
}