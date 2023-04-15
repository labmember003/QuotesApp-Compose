package com.falcon.quotesapp_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.falcon.quotesapp_compose.screens.QuoteDetail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            QuoteListItem()
            QuoteDetail()
//            3:33
        }
    }
}
