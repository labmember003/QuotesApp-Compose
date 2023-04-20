package com.falcon.quotesapp_compose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.falcon.quotesapp_compose.models.Quote
import com.google.gson.Gson

object DataManager {
//    data read and maintain kaam would be done here
    var data = emptyArray<Quote>()
    val isDataLoaded = mutableStateOf(false)
    val currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: Quote? = null

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPaging(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentPage.value = Pages.DETAIL
            currentQuote = quote
        } else {
            currentPage.value = Pages.LISTING
        }
    }

}