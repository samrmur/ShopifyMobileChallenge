package com.example.shopifychallenge.collections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopifychallenge.R
import com.example.shopifychallenge.api.models.CustomCollection

class CollectionsAdapter(private val listener: (CustomCollection) -> Unit): RecyclerView.Adapter<CollectionViewHolder>() {
    private val collections: MutableList<CustomCollection> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_collection, parent, false)
        return CollectionViewHolder(view, listener)
    }

    override fun getItemCount(): Int = collections.size

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.bind(collections[position])
    }

    fun addAll(collections: List<CustomCollection>) {
        collections.forEach {collection ->
            this.collections.add(collection)
        }
        notifyDataSetChanged()
    }
}