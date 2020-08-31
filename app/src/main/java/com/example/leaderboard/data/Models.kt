package com.example.leaderboard.data

import android.content.ClipData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class DataResult(val items: List<ClipData.Item>)

data class learning_leaders(val items: List<ClipData.Item>) {
    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("hours")
    @Expose
    var hours: Int? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("badgeUrl")
    @Expose
    var badgeUrl: String? = null
}

data class Skill_IQ_Leaders(val items: List<ClipData.Item>) {

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("score")
    @Expose
    val score: Int? = null

    @SerializedName("country")
    @Expose
    val country: String? = null

//    @SerializedName("badgeUrl")
//    @Expose
//    private val badgeUrl: String? = null

}