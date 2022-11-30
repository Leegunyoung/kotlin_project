package com.example.mini_game_project.picture_game

// 종류는 8가지
enum class Kindof{
    CHRISTMASTREE,
    REINDEER,
    SANTA,
    SNOWMAN,
    FIREPALCE,
    SNOW,
    SOCKS,
    WREATH
}

data class Stuff(val things: Kindof, var clickFlag: Boolean)


