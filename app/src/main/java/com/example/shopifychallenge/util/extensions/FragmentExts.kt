package com.example.shopifychallenge.util.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(context, message, length).show()
}