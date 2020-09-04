package com.example.leaderboard.api

import android.widget.EditText
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostData {

    private var service: PostService

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
        service = retrofit.create(PostService::class.java)
    }

    suspend fun post(
        name: EditText,
        lastName: EditText,
        email: EditText,
        link: EditText
    ): Call<Void> {
        return service.Post(name.toString(), lastName.toString(), email.toString(), link.toString())
    }

}