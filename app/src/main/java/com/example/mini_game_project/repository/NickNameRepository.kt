package com.example.mini_game_project.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


//파이어 베이스를 통해서 데이터를 가져와야함
class NickNameRepository {
    val database = Firebase.database
    val userName = database.getReference("user")
    var NameList = ArrayList<String>()

    fun observeName(name: MutableLiveData<String>){
        userName.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                name.postValue(userName.get().toString())
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    fun checkName(name: MutableLiveData<String>){
        for (i in NameList){
            if (name.toString() != i){
                NameList.add(name.toString())
            }
        }
    }
}