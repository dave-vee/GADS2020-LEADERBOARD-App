package com.example.leaderboard.api


import android.widget.EditText
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PostService {

    @POST("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun Post(
        @Field("entry.1877115667") firstName: EditText,
        @Field("entry.1877115667") lastName: EditText,
        @Field("entry.1877115667") emailAddress: EditText,
        @Field("entry.1877115667") linkToProject: EditText
    )
}