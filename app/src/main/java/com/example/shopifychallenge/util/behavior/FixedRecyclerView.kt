package com.example.shopifychallenge.util.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

/**
 * This is an unofficial fix to the a problem where RecyclerView items cannot be clicked after
 * a scroll
 * @see <a href="https://stackoverflow.com/questions/46452465/android-the-item-inside-recyclerview-cant-be-clicked-after-scroll">RecyclerView Fix</a>
 */
class FixedRecyclerView: RecyclerView {
    constructor(context: Context): super(context)

    constructor(context: Context, attributeSet: AttributeSet?): super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet?, integer: Int): super(context, attributeSet, integer)

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        val requestCancelDisallowInterceptTouchEvent = scrollState == RecyclerView.SCROLL_STATE_SETTLING
        val consumed = super.onInterceptTouchEvent(event)
        val action = event.actionMasked

        when (action) {
            MotionEvent.ACTION_DOWN -> if (requestCancelDisallowInterceptTouchEvent) {
                parent.requestDisallowInterceptTouchEvent(false)

                if (!canScrollVertically(-1) || !canScrollVertically(1)) {
                    stopScroll()
                    return false
                }
            }
        }

        return consumed
    }
}