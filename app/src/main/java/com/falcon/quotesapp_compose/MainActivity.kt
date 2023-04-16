package com.falcon.quotesapp_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.falcon.quotesapp_compose.DataManager.currentQuote
import com.falcon.quotesapp_compose.DataManager.switchPaging
import com.falcon.quotesapp_compose.models.Quote
import com.falcon.quotesapp_compose.screens.QuoteDetail
import com.falcon.quotesapp_compose.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
//        data load krne waala kaam IO thread per kiya but yaaha main thread per access kr rrhe
//        so problem nhi aa skti different values ki (because of different threads) ??

//        Nhi, because isDataLoaded is a State object, and state object are thread safe
//        means data would remain constant
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(DataManager.data) { quote ->
                switchPaging(quote)
                Log.i("cat", quote.text)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }

    } else {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.fillMaxSize(1f)
//        ) {
//            Text(
//                text = "Loading...",
//                style = MaterialTheme.typography.h4,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxSize(1f)
//            )
//        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }

    }
}

enum class Pages {
    LISTING,
    DETAIL
}

//6:13