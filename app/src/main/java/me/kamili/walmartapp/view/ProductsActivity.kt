package me.kamili.walmartapp.view

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_products.*
import me.kamili.walmartapp.App
import me.kamili.walmartapp.viewmodel.data.ProductListUI
import me.kamili.walmartapp.R
import me.kamili.walmartapp.adapters.ProductAdapter
import me.kamili.walmartapp.repository.data.Product
import java.net.ConnectException

class ProductsActivity : BaseActivity() {

    val PRODUCT_LIST = "PRODUCT_LIST"

    val productListViewModel = App.injectProductListViewModel()
    var productList : ArrayList<Product>? = null
    var dataSaved = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        if (savedInstanceState != null) {
            dataSaved = true
            productList = savedInstanceState.getParcelableArrayList(PRODUCT_LIST)
        }
    }

    override fun onStart() {
        super.onStart()

        if (dataSaved){
            showProducts( ProductListUI(productList!!, "Top ${productList!!.size} Products"))
        }else{
            showLoading()
            subscribe(productListViewModel.getProducts()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        productList = it.products as ArrayList<Product>
                        showProducts(it)
                        hideLoading()
                    }, {
                        showError()
                        hideLoading()
                    }))
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putParcelableArrayList(PRODUCT_LIST,productList!!)
    }

    fun showProducts(data: ProductListUI) {
        if (data.error == null) {
            val gridNumber = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 1 else 2
            rvProducts.layoutManager = GridLayoutManager(this, gridNumber)
            rvProducts.adapter = ProductAdapter(this, data.products)
        } else if (data.error is ConnectException) {
            //No connection...
        } else {
            showError()
        }
    }
}