package com.shopper.app.repository.categorydetail

import com.shopper.app.model.CategoryDetail
import com.shopper.app.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient): CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}