package com.example.standort.di

import com.example.standort.Constants.BASE_URL
import com.example.standort.repository.Repository
import com.example.standort.retrofit.UniApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //From ViewModel to retrofit all the dependencies....

    //First Dependency....
   @Provides
   @Singleton
   fun getRepo(api: UniApi):Repository=Repository(api)

    //Second Dependency....
    @Provides
    @Singleton
    fun getApi(retrofit: Retrofit):UniApi=retrofit.create(UniApi::class.java)

    //Third Dependency.....
    @Provides
    @Singleton
    fun getRetrofit():Retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}