package com.shopper.app.repository.productdetail

import com.shopper.app.model.Product

interface ProductDetailDataSource {

    suspend fun getProductDetail(productId: String): Product
}