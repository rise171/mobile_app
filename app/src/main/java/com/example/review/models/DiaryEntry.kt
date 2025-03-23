package com.example.review.models

import java.util.*

data class DiaryEntry(
    val id: String = "",
    val userId: String = "",
    val title: String = "",
    val content: String = "",
    val timestamp: Date = Date()
)