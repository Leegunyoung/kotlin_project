package com.example.mini_game_project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mini_game_project.repository.NickNameRepository

const val DEFAULT_NAME = "Hams"

//데이터 변경
// 뷰 모델은 데이터의 변경사항을 알려주는 라이브 데이터를 가지고 있다.
class NameViewModel : ViewModel() {
//    private var firebaseRepository : DatabaseReference = FirebaseDatabase.getInstance().reference.child("users")

    // 뮤터블 라이브 데이터 - 수정 가능한 놈
    private val _name = MutableLiveData<String>(DEFAULT_NAME)
    val name: LiveData<String> get() = _name

    // repository는 구현해놓은 NickNamerepository
    private val repository = NickNameRepository()

    //repository를 통해 database 관찰
    init{
        repository.observeName(_name)
    }

    // 이름을 받아서 repository에 있는 addName 함수를 통해 이름을 넣어줌
    fun checkName(name: String) {
        var newName = DEFAULT_NAME
        newName = name
        repository.addName(newName)
    }
}