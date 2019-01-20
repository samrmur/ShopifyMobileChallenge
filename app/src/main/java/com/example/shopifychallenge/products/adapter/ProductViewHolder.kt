package com.example.shopifychallenge.products.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopifychallenge.R
import com.example.shopifychallenge.api.models.CustomProduct
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_product.view.*

class ProductViewHolder constructor(
    itemView: View
): RecyclerView.ViewHolder(itemView) {
    fun bind(product: CustomProduct) {
        bindTitle(itemView.title, product)
        bindBody(itemView.body, product)
        bindVendor(itemView.vendor, product)
        bindTags(itemView.tags, product)
        bindImage(itemView.image, product)

        setupAdapter(itemView, product)
        setupImageButton(itemView.btn_expand, itemView.variant_list)
    }

    private fun bindTitle(view: TextView, product: CustomProduct) {
        view.text = product.title
    }

    private fun bindBody(view: TextView, product: CustomProduct) {
        view.text = product.body
    }

    private fun bindVendor(view: TextView, product: CustomProduct) {
        view.text = itemView.context.resources.getString(R.string.msg_vendor, product.vendor)
    }

    private fun bindTags(view: TextView, product: CustomProduct) {
        view.text = itemView.context.resources.getString(R.string.msg_tags, product.tags)
    }

    private fun bindImage(view: CircleImageView, product: CustomProduct) {
        Picasso.get().load(product.image.src).into(view)
    }

    private fun setupAdapter(view: View, product: CustomProduct) {
        with(view.variant_list) {
            val variantsAdapter = VariantsAdapter()
            variantsAdapter.addAll(product.variants)
            adapter = variantsAdapter
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun setupImageButton(button: ImageButton, list: RecyclerView) {
        button.setOnClickListener {
            with(list) {
                visibility = when (visibility) {
                    android.view.View.GONE -> {
                        button.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_collapse, null))
                        android.view.View.VISIBLE
                    }
                    else -> {
                        button.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_expand, null))
                        android.view.View.GONE
                    }
                }
            }
        }
    }
}