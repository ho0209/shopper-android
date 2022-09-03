package com.shopper.app.repository.home

import com.shopper.app.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}