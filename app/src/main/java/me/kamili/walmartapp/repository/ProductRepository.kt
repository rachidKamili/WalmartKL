package me.kamili.walmartapp.repository

import io.reactivex.Observable
import me.kamili.walmartapp.repository.api.ProductApi
import me.kamili.walmartapp.repository.data.Product

class ProductRepository(val productApi: ProductApi) {

    fun getProductsFromApi(): Observable<List<Product>> {
        return productApi.getProducts()
                .flatMap { response -> Observable.fromIterable(response.items).toList().toObservable() }
                .doOnNext {

//                    Timber.d("Dispatching ${it.size} users from API...")
                    storeUsersInDb(it)
                }
    }

    fun storeUsersInDb(users: List<Product>) {
//        Observable.fromCallable { userDao.insertAll(users) }
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
//                .subscribe {
////                    Timber.d("Inserted ${users.size} users from API in DB...")
//                }
    }


}