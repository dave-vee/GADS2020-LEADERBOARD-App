package com.example.leaderboard.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostData {

    private var service: GoogleService

    companion object {
        //1
        const val BASE_URL = "https://gadsapi.herokuapp.com/"
    }

    init {
        // 2
        val retrofit = Retrofit.Builder()
            // 1
            .baseUrl(BASE_URL)
            //3
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //4
        service = retrofit.create(GoogleService::class.java)
    }

    suspend fun PostData() {
        return service.Post()
    }

}