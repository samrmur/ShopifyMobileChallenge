package com.example.shopifychallenge.util.coroutines

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Lifecycle-Aware scope for fragments and activities
 * @see <a href="https://github.com/dmytrodanylyk/coroutine-recipes#lifecycle-aware-coroutine---lifecycle-observer">Lifecycle Scope</a>
 */
class LifecycleScope : CoroutineScope, LifecycleObserver {
    private var job: Job = Job()

    override val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun create() {
        job = Job()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun destroy() = job.cancel()
}