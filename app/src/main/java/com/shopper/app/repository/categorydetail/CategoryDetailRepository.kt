package com.shopper.app.repository.categorydetail

import com.shopper.app.model.CategoryDetail

class CategoryDetailRepository(
    private val remoteDataSource: CategoryDetailRemoteDataSource
) {

    suspend fun getCategoryDetail(): CategoryDetail{
        return remoteDataSource.getCategoryDetail()
    }
}