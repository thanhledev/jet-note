package com.example.jetnote.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MMMM hh:mm aaa",
        Locale.getDefault())
    return format.format(date)
}