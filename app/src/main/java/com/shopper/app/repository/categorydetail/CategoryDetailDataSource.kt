package com.shopper.app.repository.categorydetail

import com.shopper.app.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}