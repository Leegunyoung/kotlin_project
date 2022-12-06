package com.example.mini_game_project.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


//파이어 베이스를 통해서 데이터를 가져와야함
class NickNameRepository {

    // 파이어 베이스에 데이터 베이스 연결
    val database = Firebase.database

    // users 라는 key에 이름들을 저장해줌
    val userName = database.getReference("users")

    // 중복 확인을 위한 String 리스트
    var nameList = ArrayList<String>()

    // observe
    fun observeName(name: MutableLiveData<String>){
        userName.addValueEventListener(object: ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                // 데이터 베이스에 있는 이름들을 모두 리스트에 넣어줌
                for (child in snapshot.children) {
                    nameList.add(child.value.toString())
                }
                name.postValue(userName.get().toString())
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    // 이름이 있는지 없는지 확인하기 위한 함수
    fun addName(name: String){
        // true면 데이터 베이스와 리스트에 이름을 넣어줌
        var tf = true

        // 이름 리스트를 전부 순회하면서 새로 들어온 이름이 있는지 확인
        for (i in 0 until nameList.size){
            // 있다면 false
            if(name == nameList[i]){
                tf = false
            }
        }
        // tf 가 true면 데이터 베이스와 리스트에 넣어줌
        if (tf){
            nameList.add(name)
            userName.push().setValue(name)
        }
    }
}

/*
시스템마다 속도가 달라짐 기기에 따라
car 안에 모든 정보가 다 들어가야한다(객체지향적)
코드 적으로 이쁘게 짜야한다.
 */