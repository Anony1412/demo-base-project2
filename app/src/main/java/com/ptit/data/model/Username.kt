package com.ptit.data.model

import com.google.gson.annotations.SerializedName

data class Username(
    @SerializedName("_content")
    val content: String? = ""
)