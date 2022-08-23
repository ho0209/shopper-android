package com.shopper.app.repository

import com.shopper.app.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}