package com.example.standort.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

const val BASE_URl="https://mars.udacity.com/"

private val retrofit= Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URl)
    .build()


interface RetrofitApi {

    @GET("realestate")
    fun getStr(): Call<String>

}

public object MarsApi {
    val retrofitService : RetrofitApi by lazy {
        retrofit.create(RetrofitApi::class.java)
    }
}