package com.example.leaderboard.api

import com.example.leaderboard.data.SkillIQ
import com.example.leaderboard.data.learning_leaders
import retrofit2.http.GET

interface DataService {


    //Learning Hours search
    @GET("api/hours")
    suspend fun searchLearningData(): learning_leaders

    //  IQ Data search
    @GET("api/skilliq")
    suspend fun searchIQData(): SkillIQ

}