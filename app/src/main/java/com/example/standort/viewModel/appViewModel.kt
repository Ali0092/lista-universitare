package com.example.standort.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.standort.retrofit.MarsApi
import retrofit2.Call
import retrofit2.Response

class appViewModel:ViewModel() {

    private val _str= MutableLiveData<String>()
    val str: LiveData<String>
    get() = _str

    init {
getStr()
    }

     fun getStr(){
        MarsApi.retrofitService.getStr().enqueue( object: retrofit2.Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                _str.value = "Failure: " + t.message
            }
             override fun onResponse(call: Call<String>, response: Response<String>) {
                _str.value = response.body()
            }
        })
         _str.value="Lo gee..."
    }
}