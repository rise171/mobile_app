package com.example.review.models

import java.util.*

enum class MoodType {
    ANGER,       // Злость
    SADNESS,     // Грусть
    CALM,        // Спокойствие
    HAPPINESS,   // Счастье
    ANXIETY,     // Тревога
    UNDEFINED    // Не определено
}

data class MoodEntry(
    val id: String = "",
    val userId: String = "",
    val moodType: MoodType = MoodType.UNDEFINED,
    val timestamp: Date = Date(),
    val notes: String? = null
)