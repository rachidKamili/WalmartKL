package me.kamili.walmartapp.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.card_product.view.*
import me.kamili.walmartapp.R
import me.kamili.walmartapp.repository.data.Product

class ProductAdapter (val context : Context, val items : List<Product>)
                    : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_product, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder?.tvName?.text = items.get(position).name
        holder?.tvPrice?.text = "$ ${Math.floor(items.get(position).salePrice * 100) / 100}"
        Glide.with(context)
                .load(items.get(position).mediumImage)
                .apply(RequestOptions().override(180, 180))
                .into(holder.ivImage)
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvName
        val tvPrice = itemView.tvPrice
        val ivImage = itemView.ivImage
    }

}