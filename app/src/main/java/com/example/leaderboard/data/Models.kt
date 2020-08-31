package com.example.leaderboard.data


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataResult1(val items: List<SkillIQ>)
data class DataResult2(val items: List<learning_leaders>)

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
    var badgeUrl: String? = null,
)

data class SkillIQ(

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("score")
    @Expose
    val score: Int? = null,

    @SerializedName("country")
    @Expose
    val country: String? = null,

//    @SerializedName("badgeUrl")
//    @Expose
//    private val badgeUrl: String? = null

)

