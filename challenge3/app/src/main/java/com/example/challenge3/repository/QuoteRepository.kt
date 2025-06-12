package com.example.challenge3.repository

import com.example.challenge3.model.Quote
import com.example.challenge3.model.QuoteDto
import com.example.challenge3.network.QuotesApi

class QuoteRepository(private val api: QuotesApi) {
    suspend fun fetchQuote(): Quote? {
        val list: List<QuoteDto> = api.getRandomQuote()
        return list.firstOrNull()
            ?.let { dto -> Quote(content = dto.q, author = dto.a) }
    }
}
