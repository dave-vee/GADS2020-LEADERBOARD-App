package com.example.leaderboard.data


data class DataResult1(val items: List<SkillIQ>)
data class DataResult2(val items: List<learning_leaders>)

data class learning_leaders(
    var name: String?,
    var hours: Int?,
    var country: String?,

//    @SerializedName("badgeUrl")
//    @Expose
//    var badgeUrl: String? = null
)

data class SkillIQ(


    val name: String?,
    val score: Int?,
    val country: String?

//    @SerializedName("badgeUrl")
//    @Expose
//    private val badgeUrl: String? = null

)

data class Post(
    var Name: String?,
    var LastName: String?,
    var email: String?,
    var link: String?
)
