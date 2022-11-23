package com.example.mini_game_project

enum class Kindof{
    CHRISTMASTREE,
    REINDEER,
    SANTA,
    SNOWMAN
}

data class Stuff(val things: Kindof, var clickFlag: Boolean)


