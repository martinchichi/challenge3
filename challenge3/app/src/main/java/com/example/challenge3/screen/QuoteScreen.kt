package com.example.challenge3.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.challenge3.ui.theme.QuoteViewModel

@Composable
fun QuoteScreen(
    viewModel: QuoteViewModel = viewModel()
) {
    val quote by viewModel.quote.collectAsState(initial = null)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4EDEB))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = cardElevation(defaultElevation = 4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = quote?.content ?: "cargando...",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = quote?.author.orEmpty(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                        IconButton(onClick = { viewModel.fetchQuote() }) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Actualizar"
                            )
                        }
                    }
                }
            }
        }
    }
}
