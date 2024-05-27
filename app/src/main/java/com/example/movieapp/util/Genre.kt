package com.example.movieapp.util

enum class Genre(val id: Int, val displayName: String) {
    ACTION(28, "Action"),
    ADVENTURE(12, "Adventure"),
    ANIMATION(16, "Animation"),
    COMEDY(35, "Comedy"),
    CRIME(80, "Crime"),
    HISTORY(36, "History"),
    HORROR(27, "Horror"),
    SCIENCE_FICTION(878, "Science Fiction"),
    WAR(10752, "War");

    companion object {
        fun fromId(id: Int): Genre? {
            return values().find { it.id == id }
        }
    }
}
