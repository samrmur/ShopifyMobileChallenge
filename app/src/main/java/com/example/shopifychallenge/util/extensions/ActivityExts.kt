package com.example.shopifychallenge.util.extensions

import androidx.annotation.AnimRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Extension for adding a fragment onto an activity
 * @param tag A string ID for the fragment
 * @param layoutId The ID of the layout the fragment is being stored in
 * @param enter The animation ID for the entering animation
 * @param exit The animation ID for the exiting animation
 * @param newInstance the function creating the instance of the fragment
 */
fun AppCompatActivity.addFragment(
    tag: String,
    layoutId: Int,
    @AnimRes enter: Int = 0,
    @AnimRes exit: Int = 0,
    newInstance: () -> Fragment
) {
    val fragment = supportFragmentManager.findFragmentByTag(tag) ?: newInstance()
    supportFragmentManager.beginTransaction()
            .setCustomAnimations(enter, exit, 0, 0)
            .replace(layoutId, fragment, tag)
            .commit()
}

/**
 * Extension for adding a fragment onto an activity
 * @param tag A string ID for the fragment
 * @param layoutId The ID of the layout the fragment is being stored in
 * @param enter The animation ID for the entering animation
 * @param exit The animation ID for the exiting animation
 * @param popEnter The animation ID for the entering animation after popping from back stack
 * @param popExit The animation ID for the exiting animation after popping from back stack
 * @param newInstance the function creating the instance of the fragment
 */
fun AppCompatActivity.addFragmentToBackStack(
    tag: String,
    layoutId: Int,
    @AnimRes enter: Int = 0,
    @AnimRes exit: Int = 0,
    @AnimRes popEnter: Int = 0,
    @AnimRes popExit: Int = 0,
    newInstance: () -> Fragment
) {
    val fragment = supportFragmentManager.findFragmentByTag(tag) ?: newInstance()
    supportFragmentManager.beginTransaction()
            .setCustomAnimations(enter, exit, popEnter, popExit)
            .replace(layoutId, fragment, tag)
            .addToBackStack(tag)
            .commit()
}