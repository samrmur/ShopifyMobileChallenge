package com.example.shopifychallenge.collections.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopifychallenge.R
import com.example.shopifychallenge.api.models.CustomCollection
import com.example.shopifychallenge.util.extensions.DateTimeHelper
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_collection.view.*
import java.util.*

class CollectionViewHolder constructor(
    itemView: View,
    private val listener: (CustomCollection) -> Unit
): RecyclerView.ViewHolder(itemView) {
    fun bind(collection: CustomCollection) {
        bindTitle(itemView.title, collection)
        bindDate(itemView.updated_at, collection)
        bindImage(itemView.image, collection)
        itemView.setOnClickListener { listener(collection) }
    }

    private fun bindTitle(view: TextView, collection: CustomCollection) {
        view.text = collection.title
    }

    private fun bindDate(view: TextView, collection: CustomCollection) {
        val date = DateTimeHelper.instance.getReadableDate(collection.updatedAt)
        view.text = itemView.context.getString(R.string.msg_last_updated, date)
    }

    private fun bindImage(view: ImageView, collection: CustomCollection) {
        Picasso.get().load(collection.image.src).into(view)
    }
}