package com.falcon.quotesapp_compose

import android.content.Context
import com.falcon.quotesapp_compose.models.Quote
import com.google.gson.Gson

class DataManager {
//    data read and maintain kaam would be done here
    private var data = emptyArray<Quote>()


    fun loadAssetsFromFile() {
        data[0].text
    }
    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
    }

}