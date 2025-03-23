package com.example.review.models

import java.util.*

data class Article(
    val id: String = "",
    val title: String = "",
    val content: String = "",
    val author: String = "",
    val publishedDate: Date = Date()
)