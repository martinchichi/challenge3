// app/src/main/java/com/example/challenge3/MainActivity.kt
package com.example.challenge3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.challenge3.screen.QuoteScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuoteScreen()
        }
    }
}
