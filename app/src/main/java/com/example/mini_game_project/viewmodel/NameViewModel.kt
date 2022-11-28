package com.example.mini_game_project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mini_game_project.repository.NickNameRepository

val DEFAULT_NAME = "Hams"

class NameViewModel : ViewModel() {
    private val _name = MutableLiveData<String>(DEFAULT_NAME)
    val name: LiveData<String> get() = _name

    private val repository = NickNameRepository()

    init {
        repository.observeName(_name)
    }

    private fun checkName(name: String) {
        var newName = DEFAULT_NAME
        newName = name

    }

    fun tryName(name: String){
        checkName(name)
    }
}