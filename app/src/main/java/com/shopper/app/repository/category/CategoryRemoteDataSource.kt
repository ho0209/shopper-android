package com.shopper.app.repository.category

import com.shopper.app.model.Category
import com.shopper.app.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {

    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}