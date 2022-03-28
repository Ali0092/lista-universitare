package com.example.standort.retrofit

import com.example.standort.Constants.CountyName
import com.example.standort.model.UniItem
import retrofit2.Response
import retrofit2.http.GET

interface UniApi {

    @GET("/search?country=${CountyName}")
    fun getUniList():Response<List<UniItem>>

}