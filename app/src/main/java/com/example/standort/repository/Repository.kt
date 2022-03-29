package com.example.standort.repository

import com.example.standort.model.UniItem
import com.example.standort.retrofit.UniApi
import retrofit2.Response

class Repository(private val api: UniApi) {

    suspend fun getUniItem(name:String):Response<List<UniItem>>{
      return api.getUniList(name)
    }
}