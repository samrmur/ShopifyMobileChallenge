package com.example.shopifychallenge.products.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopifychallenge.R
import com.example.shopifychallenge.api.models.ProductVariant
import kotlinx.android.synthetic.main.item_variant.view.*

class VariantViewHolder constructor(
    itemView: View
): RecyclerView.ViewHolder(itemView) {
    fun bind(variant: ProductVariant) {
        bindTitle(itemView.title, variant)
        bindPrice(itemView.price, variant)
        bindInventoryCount(itemView.inventoryCount, variant)
    }

    private fun bindTitle(view: TextView, variant: ProductVariant) {
        view.text = variant.title
    }

    private fun bindPrice(view: TextView, variant: ProductVariant) {
        view.text = itemView.context.resources.getString(R.string.msg_price, variant.price)
    }

    private fun bindInventoryCount(view: TextView, variant: ProductVariant) {
        view.text = itemView.context.resources.getString(R.string.msg_inventory_count, variant.inventoryCount)
    }
}