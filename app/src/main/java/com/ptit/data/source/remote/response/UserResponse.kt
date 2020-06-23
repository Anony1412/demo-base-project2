package com.ptit.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.ptit.data.model.User

data class UserResponse(
    @SerializedName("user")
    val user: User? = null
)
