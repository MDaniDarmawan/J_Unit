package com.example.unit_test

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
data class ChatMessage(
    val message: String,
    val isQuestion: Boolean,
    val timestamp: Long = System.currentTimeMillis()
){
    fun getFormattedTime(): String {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        val date = Date(timestamp)
        return sdf.format(date)
    }
}

