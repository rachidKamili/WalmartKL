package me.kamili.walmartapp

import android.app.Application
import me.kamili.walmartapp.repository.ProductRepository
import me.kamili.walmartapp.repository.api.ProductApi
import me.kamili.walmartapp.viewmodel.ProductListViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class App : Application() {

    //todo  DAGGER2
    companion object {
        private lateinit var interceptor: HttpLoggingInterceptor
        private lateinit var okHttpClient: OkHttpClient
        private lateinit var retrofit: Retrofit
        private lateinit var productApi: ProductApi
        private lateinit var productRepository: ProductRepository
        private lateinit var productListViewModel: ProductListViewModel

        fun injectProductListViewModel() = productListViewModel
    }

    override fun onCreate() {
        super.onCreate()


        interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl("http://api.walmartlabs.com/")
                .build()

        productApi = retrofit.create(ProductApi::class.java)

        productRepository = ProductRepository(productApi)

        productListViewModel = ProductListViewModel(productRepository)
    }
}