package me.kamili.walmartapp.viewmodel.data

import me.kamili.walmartapp.repository.data.Product

data class ProductListUI(val products: List<Product>, val message: String, val error: Throwable? = null)
