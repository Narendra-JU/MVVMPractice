package com.example.retrofitmvvmpractice.model

import io.reactivex.Single
import retrofit2.http.GET

interface PlaceholderApi {
    @GET("users")
    fun getPlaceholders():Single<List<Placeholder>>

}