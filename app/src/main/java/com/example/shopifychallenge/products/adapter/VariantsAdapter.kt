package com.example.shopifychallenge.products.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopifychallenge.R
import com.example.shopifychallenge.api.models.ProductVariant

class VariantsAdapter: RecyclerView.Adapter<VariantViewHolder>() {
    private val variants: MutableList<ProductVariant> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VariantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_variant, parent, false)
        return VariantViewHolder(view)
    }

    override fun getItemCount(): Int = variants.size

    override fun onBindViewHolder(holder: VariantViewHolder, position: Int) {
        holder.bind(variants[position])
    }

    fun addAll(variants: List<ProductVariant>) {
        variants.forEach { variant ->
            this.variants.add(variant)
        }
        notifyDataSetChanged()
    }
}