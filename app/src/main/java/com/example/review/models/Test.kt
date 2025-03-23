package com.example.review.models

data class Test (
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val questions: List<String> = emptyList(),
    val category: String = ""
)