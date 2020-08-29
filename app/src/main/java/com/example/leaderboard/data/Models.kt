package com.example.leaderboard.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class learning_leaders(
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("hours")
    @Expose
    var hours: Int? = null,

    @SerializedName("country")
    @Expose
    var country: String? = null,

    @SerializedName("badgeUrl")
    @Expose
    var badgeUrl: String? = null
)

data class Skill_IQ_Leaders(

    @SerializedName("name")
    @Expose
    private val name: String? = null,

    @SerializedName("score")
    @Expose
    private val score: Int? = null,

    @SerializedName("country")
    @Expose
    private val country: String? = null,

    @SerializedName("badgeUrl")
    @Expose
    private val badgeUrl: String? = null

)