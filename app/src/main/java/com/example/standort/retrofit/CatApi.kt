package com.example.standort.retrofit

import com.example.standort.Constants.BASE_URL
import com.example.standort.Constants.BASE_URL2
import com.example.standort.model.Fact
import com.example.standort.model.Fact2
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL2)
    .build()


interface CatApiService{

    @GET("/api/breeds/image/random")
    fun getFact2(): Call<Fact2>
}
object FactApi{
    val retrofitService:CatApiService by lazy {
        retrofit.create(CatApiService::class.java)
    }
}

