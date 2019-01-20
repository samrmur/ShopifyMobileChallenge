package com.example.shopifychallenge.util.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * Very simple date & time helper
 * @author Samer Alabi
 */
class DateTimeHelper {
    private val dateParser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.US)
    private val dateFormatter = SimpleDateFormat("hh:mm a 'on' MMM dd, yyyy", Locale.US)

    companion object {
        val instance = DateTimeHelper()
    }

    fun getReadableDate(date: String): String = dateFormatter.format(dateParser.parse(date))
}