package me.kamili.walmartapp.repository.api

import io.reactivex.Observable
import me.kamili.walmartapp.repository.data.ResponseProducts
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "bz4eq7tztz3zfkfekqmxwgfb"

interface ProductApi {

    @GET("v1/paginated/items?format=json&apiKey=$API_KEY")
    fun getProducts(): Observable<ResponseProducts>

    //todo: Pagination!!!!
    @GET("v1/paginated/items?format=json&apiKey=$API_KEY")
    fun getNextProducts(@Query("maxId") nextPage: String): Observable<ResponseProducts>

}