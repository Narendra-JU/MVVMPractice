package com.example.retrofitmvvmpractice.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PlaceholderService {
    val BASE_URL="https://jsonplaceholder.typicode.com"
    val api:PlaceholderApi

    fun getPlaceholders():Single<List<Placeholder>>{
        return api.getPlaceholders()
    }

    init{
        api=Retrofit.Builder()//creates the framework for retrofit
            .baseUrl(BASE_URL)//sets the url to the URL above
            .addConverterFactory(GsonConverterFactory.create())//converts the GSON code at the location to a Kotlin code
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//transform Placeholder to a viewholder like variable
            .build()
            .create(PlaceholderApi::class.java)
    }


}