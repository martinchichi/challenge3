// app/src/main/java/com/example/challenge3/ui/theme/QuoteViewModel.kt
package com.example.challenge3.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge3.model.Quote
import com.example.challenge3.network.QuotesApi
import com.example.challenge3.repository.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://zenquotes.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: QuotesApi = retrofit.create(QuotesApi::class.java)
    private val repository = QuoteRepository(api)

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> = _quote.asStateFlow()

    // 4) Al iniciar, ya traemos la primera frase
    init {
        fetchQuote()
    }

    fun fetchQuote() {
        viewModelScope.launch {
            try {
                repository.fetchQuote()?.let { _quote.value = it }
            } catch (e: Exception) {
                _quote.value = Quote("Error al cargar", "")
                e.printStackTrace()
            }
        }
    }
}
