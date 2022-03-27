package com.example.standort.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.standort.model.Fact2
import com.example.standort.retrofit.FactApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class appViewModel:ViewModel() {
    private val _fact=MutableLiveData<Fact2>()
    val fact:LiveData<Fact2>
    get() = _fact

    init {
        getFact()
    }

    fun getFact(){
    FactApi.retrofitService.getFact2().enqueue(object : Callback<Fact2>{
        override fun onResponse(call: Call<Fact2>, response: Response<Fact2>) {
            _fact.value=response.body()
        }

        override fun onFailure(call: Call<Fact2>, t: Throwable) {
         Log.d("Response","Check1")
        }
    })

    }
}