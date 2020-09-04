package com.example.leaderboard.api


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PostService {

    @POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun Post(
        @Field("entry.1877115667") firstName: String,
        @Field("entry.1877115667") lastName: String,
        @Field("entry.1877115667") emailAddress: String,
        @Field("entry.1877115667") linkToProject: String
    ): Call<Void>
}