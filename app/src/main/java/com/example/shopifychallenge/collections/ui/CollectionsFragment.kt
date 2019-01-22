package com.example.shopifychallenge.collections.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopifychallenge.R
import com.example.shopifychallenge.api.models.CustomCollection
import com.example.shopifychallenge.collections.adapter.CollectionsAdapter
import com.example.shopifychallenge.collections.presentation.CollectionsPresenter
import com.example.shopifychallenge.collections.presentation.CollectionsView
import com.example.shopifychallenge.util.extensions.hideView
import com.example.shopifychallenge.util.extensions.showView
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_collections.*
import javax.inject.Inject
import com.example.shopifychallenge.util.view.CustomDividerDecoration

/**
 * Displays a list of collections from Shopify API
 * @author Samer Alabi
 */
class CollectionsFragment: Fragment(), CollectionsView, View.OnClickListener {
    @Inject
    lateinit var presenter: CollectionsPresenter

    private lateinit var adapter: CollectionsAdapter

    companion object {
        const val COLLECTIONS_FRAGMENT_TAG: String = "COLLECTIONS_FRAGMENT"
        fun newCollectionsInstance(): CollectionsFragment = CollectionsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_collections, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupAdapter()
    }

    override fun onResume() {
        super.onResume()
        presenter.getCollections()
    }

    override fun onCollectionsReceived(collections: List<CustomCollection>) {
        adapter.addAll(collections)
    }

    override fun onStartLoading() {
        text_empty_list.hideView()
        loading_bar.showView()
    }

    override fun onFinishLoading() {
        loading_bar.hideView()
    }

    override fun onError(message: String) {
        text_empty_list.showView()
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun onGenericError() {
        text_empty_list.showView()
    }

    override fun onClick(view: View) {
        presenter.getCollections()
    }

    private fun setupAdapter() {
        adapter = CollectionsAdapter { collection ->
            presenter.toProducts(
                collection.id,
                collection.title,
                collection.body,
                collection.publishedAt,
                collection.updatedAt,
                collection.image.src
            )
        }
        collections_list.adapter = adapter

        with(collections_list) {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(CustomDividerDecoration(context, resources.getDimensionPixelSize(R.dimen.divider_image_start_margin), 0))
            itemAnimator = DefaultItemAnimator()
            isNestedScrollingEnabled = false
        }
    }

    private fun setupViews() {
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.setSupportActionBar(toolbar)

        text_empty_list.setOnClickListener(this)
    }
}