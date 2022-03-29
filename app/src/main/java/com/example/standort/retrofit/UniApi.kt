package com.example.standort.retrofit



import com.example.standort.model.UniItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UniApi {


    @GET("/search")
   suspend fun getUniList(@Query("country") country:String):Response<List<UniItem>>

}