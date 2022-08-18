package com.shopper.app

import android.content.Context
import android.util.Log

class AssetLoader {

    fun getJsonString(context: Context, filename: String): String? {
        return kotlin.runCatching {
            loadAsset(context, filename)
        }.getOrNull()
    }

    private fun loadAsset(context: Context, filename: String): String{
        return context.assets.open(filename).use {inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)

        }
    }
}