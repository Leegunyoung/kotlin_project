package com.example.mini_game_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nickname_and_character.*

class Nickname : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nickname_and_character)

        nickname_button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}