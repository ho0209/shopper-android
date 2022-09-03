package com.shopper.app.repository.category

import com.shopper.app.model.Category

interface CategoryDataSource {
   suspend fun getCategories(): List<Category>
}