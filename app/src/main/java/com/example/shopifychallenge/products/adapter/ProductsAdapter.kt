package com.example.shopifychallenge.products.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopifychallenge.R
import com.example.shopifychallenge.api.models.CustomProduct

class ProductsAdapter: RecyclerView.Adapter<ProductViewHolder>() {
    private val products: MutableList<CustomProduct> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun addAll(products: List<CustomProduct>) {
        products.forEach {product ->
            this.products.add(product)
        }
        notifyDataSetChanged()
    }
}