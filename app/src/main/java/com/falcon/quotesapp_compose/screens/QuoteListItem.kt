package com.falcon.quotesapp_compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.falcon.quotesapp_compose.R
import com.falcon.quotesapp_compose.models.Quote

@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onClick(quote)
            }
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        // padding from its parent
        // paddding from parent of Row
        ) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                contentDescription = "Quote",
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
                    .background(Color.Black)
            )
//            Alternate Way
//            Image(
//                painter = painterResource(id = R.drawable.format_quote_48px),
//                colorFilter = ColorFilter.tint(Color.White),
//                alignment = Alignment.TopStart,
//                contentDescription = "Quote",
//                modifier = Modifier
//                    .size(40.dp)
//                    .rotate(180F)
//                    .background(Color.Black)
//            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(
                modifier = Modifier.weight(1f)
                // column taking full width AVAILABLE
                // baaki sab we can say its wrap content
            ) {
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.body2,
//                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(0.dp)
                )
                Divider(
                    color = Color.Gray.copy(alpha = 0.2f),
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.4f)
                        // .4f says take only 40% of the space available
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(0.dp)
                )
//                Image(painter = painterResource(id = R.drawable.format_quote_48px), contentDescription = )
            }

        }
    }
}

