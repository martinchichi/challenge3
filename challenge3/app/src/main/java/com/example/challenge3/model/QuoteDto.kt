package com.example.challenge3.model

import com.google.gson.annotations.SerializedName

data class QuoteDto(
    @SerializedName("q") val q: String,
    @SerializedName("a") val a: String
)
