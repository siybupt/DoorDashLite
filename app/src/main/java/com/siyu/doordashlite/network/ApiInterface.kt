package com.siyu.doordashlite.network

import com.siyu.doordashlite.entity.Restaurant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("restaurant") fun getNearbyRestaurants(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int): Call<List<Restaurant>>
}