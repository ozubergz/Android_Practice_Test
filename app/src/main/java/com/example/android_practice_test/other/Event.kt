package com.example.android_practice_test.other

open class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set // Allow external read but no write

    /**
     * Returns the content and prevents its use again
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /*
    * Returns the content, even if it's already been handled.
    * */

    fun peekContent(): T = content
}