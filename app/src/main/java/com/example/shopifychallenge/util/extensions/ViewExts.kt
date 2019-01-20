package com.example.shopifychallenge.util.extensions

import android.view.View

fun View.hideView() {
    if (visibility != View.GONE)
        visibility = View.GONE
}

fun View.showView() {
    if (visibility != View.VISIBLE)
        visibility = View.VISIBLE
}