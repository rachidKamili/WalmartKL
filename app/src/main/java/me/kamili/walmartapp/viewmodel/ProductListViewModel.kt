package me.kamili.walmartapp.viewmodel

import io.reactivex.Observable
import me.kamili.walmartapp.repository.ProductRepository
import me.kamili.walmartapp.viewmodel.data.ProductListUI
import java.util.concurrent.TimeUnit

class ProductListViewModel(val productRepository: ProductRepository) {

    fun getProducts(): Observable<ProductListUI> {
        //Create the data for your UI, the users lists and maybe some additional data needed as well
        return productRepository.getProductsFromApi()
                //Drop DB data if we can fetch item fast enough from the API
                //to avoid UI flickers
                .debounce(400, TimeUnit.MILLISECONDS)
                .map {
                    //Mapping users to UIData...
                    val list = it.take(20)
                    ProductListUI(list, "Top ${list.size} Products")
                }
                .onErrorReturn {
                    ProductListUI(emptyList(), "An error occurred", it)
                }
    }

}