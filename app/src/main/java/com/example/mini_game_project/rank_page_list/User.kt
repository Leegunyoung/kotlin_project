package com.example.mini_game_project.rank_page_list


enum class ELevel {
    GOLD,
    SILVER,
    BRONZE
}
data class User(var name: String = "",
                var level: String = "",
                var time : Int = 0,
                var location: String = "")