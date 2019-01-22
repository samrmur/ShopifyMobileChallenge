package com.example.shopifychallenge.products.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopifychallenge.R
import com.example.shopifychallenge.api.models.CustomProduct
import com.example.shopifychallenge.products.adapter.ProductsAdapter
import com.example.shopifychallenge.products.presentation.ProductsPresenter
import com.example.shopifychallenge.products.presentation.ProductsView
import com.example.shopifychallenge.util.extensions.hideView
import com.example.shopifychallenge.util.extensions.showToast
import com.example.shopifychallenge.util.extensions.showView
import com.example.shopifychallenge.util.view.CustomDividerDecoration
import com.google.android.material.appbar.AppBarLayout
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_products.*
import javax.inject.Inject

class ProductsFragment: Fragment(), ProductsView, AppBarLayout.OnOffsetChangedListener, View.OnClickListener {
    @Inject
    lateinit var presenter: ProductsPresenter

    private lateinit var adapter: ProductsAdapter

    private var showTitle = false
    private var range = -1

    private var id: Long = 0
    private lateinit var title: String
    private lateinit var body: String
    private lateinit var publishedAt: String
    private lateinit var updatedAt: String
    private lateinit var imageSrc: String

    companion object {
        const val PRODUCTS_FRAGMENT_TAG = "PRODUCTS_FRAGMENT"

        private const val BUNDLE_COLLECTION_ID = "BUNDLE_COLLECTION_ID"
        private const val BUNDLE_COLLECTION_TITLE = "BUNDLE_COLLECTION_TITLE"
        private const val BUNDLE_COLLECTION_BODY = "BUNDLE_COLLECTION_BODY"
        private const val BUNDLE_COLLECTION_PUBLISHED_AT = "BUNDLE_COLLECTION_published_AT"
        private const val BUNDLE_COLLECTION_UPDATED_AT = "BUNDLE_COLLECTION_UPDATED_AT"
        private const val BUNDLE_COLLECTION_IMAGE = "BUNDLE_COLLECTION_IMAGE"

        fun newProductsInstance(
            id: Long,
            title: String,
            body: String,
            publishedAt: String,
            updatedAt: String,
            imageSrc: String
        ): ProductsFragment {
            val fragment = ProductsFragment()

            val bundle = Bundle()
            bundle.putLong(BUNDLE_COLLECTION_ID, id)
            bundle.putString(BUNDLE_COLLECTION_TITLE, title)
            bundle.putString(BUNDLE_COLLECTION_BODY, body)
            bundle.putString(BUNDLE_COLLECTION_PUBLISHED_AT, publishedAt)
            bundle.putString(BUNDLE_COLLECTION_UPDATED_AT, updatedAt)
            bundle.putString(BUNDLE_COLLECTION_IMAGE, imageSrc)

            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        val bundle = arguments

        if (bundle != null) {
            id =  bundle.getLong(BUNDLE_COLLECTION_ID)
            title = bundle.getString(BUNDLE_COLLECTION_TITLE, "")
            body = bundle.getString(BUNDLE_COLLECTION_BODY, "")
            publishedAt = bundle.getString(BUNDLE_COLLECTION_PUBLISHED_AT, "")
            updatedAt = bundle.getString(BUNDLE_COLLECTION_UPDATED_AT, "")
            imageSrc = bundle.getString(BUNDLE_COLLECTION_IMAGE, "")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_products, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        app_bar.addOnOffsetChangedListener(this)
        setupHeader()
        setupAdapter()
        text_empty_list.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        toolbar.title = ""
        presenter.getProducts(id)
    }

    override fun onProductsReceived(products: List<CustomProduct>) {
        adapter.addAll(products)
    }

    override fun onStartLoading() {
        loading_bar?.showView()
    }

    override fun onFinishLoading() {
        loading_bar?.hideView()
    }

    override fun onError(message: String) {
        showToast(message)
        onErrorOccurred()
    }

    override fun onGenericError() {
        showToast(resources.getString(R.string.msg_generic_error))
        onErrorOccurred()
    }

    override fun onOffsetChanged(layout: AppBarLayout, verticalOffset: Int) {
        if (range == -1)
            range = layout.totalScrollRange

        if (range + verticalOffset == 0) {
            collapsing_toolbar.title = title
            showTitle = true
        } else if (showTitle) {
            collapsing_toolbar.title = ""
            showTitle = false
        }
    }

    override fun onClick(view: View) {
        presenter.getProducts(id)
    }

    private fun onErrorOccurred() {
        loading_bar?.hideView()
        text_empty_list?.showView()
    }

    private fun setupAdapter() {
        adapter = ProductsAdapter()
        products_list.adapter = adapter

        with(products_list) {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(CustomDividerDecoration(context, resources.getDimensionPixelSize(R.dimen.divider_image_start_margin), 0))
            itemAnimator = DefaultItemAnimator()
            isNestedScrollingEnabled = true
        }
    }

    private fun setupHeader() {
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(toolbar)
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.title = ""
        title_view.text = title
        body_view.text = body
        Picasso.get().load(imageSrc).into(image)
    }
}