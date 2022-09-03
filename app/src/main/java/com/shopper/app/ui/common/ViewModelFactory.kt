package com.shopper.app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shopper.app.AssetLoader
import com.shopper.app.network.ApiClient
import com.shopper.app.repository.category.CategoryRemoteDataSource
import com.shopper.app.repository.category.CategoryRepository
import com.shopper.app.repository.home.HomeAssetDataSource
import com.shopper.app.repository.home.HomeRepository
import com.shopper.app.ui.category.CategoryViewModel
import com.shopper.app.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T

            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}