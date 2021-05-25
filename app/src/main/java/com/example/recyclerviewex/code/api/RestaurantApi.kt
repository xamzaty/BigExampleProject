package com.example.recyclerviewex.code.api

import com.example.recyclerviewex.code.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=40")
    suspend fun getRestaurants(): List<Restaurant>
}