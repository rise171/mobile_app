package com.example.review.models

data class AuthUser(
    val userId: String = "",
    val email: String = "",
    val username: String = "",
    val token: String? = null
)
