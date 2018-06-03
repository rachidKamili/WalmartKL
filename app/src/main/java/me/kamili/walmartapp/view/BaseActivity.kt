package me.kamili.walmartapp.view

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity : AppCompatActivity() {

    val subscriptions = CompositeDisposable()
    var progressDialog: ProgressDialog? = null

    fun subscribe(disposable: Disposable): Disposable {
        subscriptions.add(disposable)
        return disposable
    }

    override fun onStop() {
        super.onStop()
        subscriptions.clear()
    }

    fun showLoading() {
        progressDialog = ProgressDialog(this)
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog!!.setCancelable(true)
        progressDialog!!.setMessage("Loading....")
        progressDialog!!.show()
    }

    fun hideLoading() {
        if (progressDialog!!.isShowing()) {
            progressDialog!!.dismiss()
        }
    }

    fun showError() {
        Toast.makeText(applicationContext, "An error occurred :(", Toast.LENGTH_SHORT).show()
    }

}