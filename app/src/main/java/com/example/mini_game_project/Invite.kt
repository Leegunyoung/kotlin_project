package com.example.mini_game_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class Invite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.invite)

        invite_btn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}