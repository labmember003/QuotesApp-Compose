package com.falcon.quotesapp_compose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.falcon.quotesapp_compose.DataManager
import com.falcon.quotesapp_compose.models.Quote

@Composable
fun QuoteList(
        data: List<Quote>, onClick: (quote: Quote) -> Unit
    ) {
    LazyColumn(content = {
        items(data) { item ->
            QuoteListItem(item, onClick)
        }
    })
}