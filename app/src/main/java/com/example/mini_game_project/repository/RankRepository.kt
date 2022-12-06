package com.example.mini_game_project.repository

import androidx.lifecycle.MutableLiveData
import com.example.mini_game_project.rank_page_list.User
import com.example.mini_game_project.viewmodel.DEFAULT_RANK
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class RankRepository{
    val database = Firebase.database
    val rankRef = database.getReference("users")

    fun observeRank(newRank: MutableLiveData<List<User>>, nowRank: MutableLiveData<String>, lastRank: MutableLiveData<String>) {
        rankRef.orderByChild("score").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}