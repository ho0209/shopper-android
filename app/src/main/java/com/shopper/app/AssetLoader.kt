package com.shopper.app

import android.content.Context
import android.util.Log

class AssetLoader(private val context: Context) {

    fun getJsonString(filename: String): String? {
        return kotlin.runCatching {
            loadAsset(filename)
        }.getOrNull()
    }

    private fun loadAsset(filename: String): String{
        return context.assets.open(filename).use {inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)

        }
    }
}