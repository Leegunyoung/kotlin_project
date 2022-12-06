package com.example.mini_game_project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mini_game_project.rank_page_list.User
import com.example.mini_game_project.repository.RankRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.sql.Date
import java.text.SimpleDateFormat

val DEFAULT_RANK = User(" ","-1",0,"1")
class PictureViewModel : ViewModel() {

    private val _rank = MutableLiveData<List<User>>()
    val rank: LiveData<List<User>> get() = _rank

    private val _last = MutableLiveData<String>("-1")
    val last: LiveData<String> get() = _last


    private val _nowRank = MutableLiveData<String>()
    val nowRank: LiveData<String> get() = _nowRank


    private val repository = RankRepository()

    init{
        repository.observeRank(_rank, _nowRank, _last)
    }

}