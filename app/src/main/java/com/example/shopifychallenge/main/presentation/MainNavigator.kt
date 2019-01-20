package com.example.shopifychallenge.main.presentation

import com.example.shopifychallenge.R
import com.example.shopifychallenge.collections.ui.CollectionsFragment.Companion.COLLECTIONS_FRAGMENT_TAG
import com.example.shopifychallenge.collections.ui.CollectionsFragment.Companion.newCollectionsInstance
import com.example.shopifychallenge.main.ui.MainActivity
import com.example.shopifychallenge.products.ui.ProductsFragment.Companion.PRODUCTS_FRAGMENT_TAG
import com.example.shopifychallenge.products.ui.ProductsFragment.Companion.newProductsInstance
import com.example.shopifychallenge.util.extensions.addFragment
import com.example.shopifychallenge.util.extensions.addFragmentToBackStack

/**
 * This class acts as a mediator for the MainActivity when switching to other fragments
 * @author Samer Alabi
 */
class MainNavigator(private val activity: MainActivity) {
    /**
     * Goes to the collections fragment
     */
    fun toCollections() {
        activity.addFragment(COLLECTIONS_FRAGMENT_TAG, R.id.fragment_container) {
            newCollectionsInstance()
        }
    }

    /**
     * Goes to the products fragment
     */
    fun toProducts(
        id: Long,
        title: String,
        body: String,
        createdAt: String,
        updatedAt: String,
        imageSrc: String
    ) {
        activity.addFragmentToBackStack(
            PRODUCTS_FRAGMENT_TAG,
            R.id.fragment_container,
            R.anim.enter_from_right,
            R.anim.exit_to_right,
            R.anim.enter_from_left,
            R.anim.exit_to_left
        ) {
            newProductsInstance(id, title, body, createdAt, updatedAt, imageSrc)
        }
    }
}