package com.falcon.quotesapp_compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.falcon.quotesapp_compose.R
import com.falcon.quotesapp_compose.models.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onCLick: (quote: Quote) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Quotes App",
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(20.dp)
        )
        QuoteList(data.toList(), onCLick)
    }
}