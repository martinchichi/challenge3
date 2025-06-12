package com.example.challenge3.network

import com.example.challenge3.model.QuoteDto
import retrofit2.http.GET

interface QuotesApi {
    @GET("random")
    suspend fun getRandomQuote(): List<QuoteDto>
}
