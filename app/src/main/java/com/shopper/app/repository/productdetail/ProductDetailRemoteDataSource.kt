package com.shopper.app.repository.productdetail

import com.shopper.app.model.Product
import com.shopper.app.network.ApiClient

class ProductDetailRemoteDataSource(
    private val api: ApiClient
) : ProductDetailDataSource{

    override suspend fun getProductDetail(productId: String): Product {
       return api.getProductDetail(productId)
    }

}