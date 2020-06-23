package com.ptit.data.model

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("nsid")
    val id: String? = "",
    @SerializedName("username")
    val username: Username? = null
)
