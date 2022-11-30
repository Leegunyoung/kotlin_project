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
    var count = 0
    val dbList = ArrayList<User>()
    var nowLocation : String = " "

    fun observeRank(newRank: MutableLiveData<List<User>>, nowRank: MutableLiveData<String>, lastRank: MutableLiveData<String>) {
        rankRef.orderByChild("score").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}
//    fun checkScore(list: ArrayList<User>, newScore: User){
//        val count = list.reversed()[list.size-1]
//        if(count.time < newScore.time){
//            postRank(count.location, newScore)
//        }
//    }
//
//    fun postRank(location: String, newScore: User) {
//        val pushScore = newScore
//        pushScore.location = location
//        nowLocation = location
//        rankRef.child(location).setValue(pushScore)
//    }

    //                count = 0
//                dbList.clear()
//
//                snapshot.children.forEach {
//                    dbList.add(it.getValue<User>() ?: DEFAULT_RANK)
//                }
//
//                for(i in (dbList.size - 1) downTo 0 ){
//                    dbList[count].level = (i+1).toString()
//                    count += 1
//                }
//                // 오름차순 -> 내림차순
//                newRank.postValue(dbList.reversed())
//
//                for (rank in dbList) {
//
//                    if ("10" == rank.level) {
//                        lastRank.value = rank.time.toString()
//                    }
//
//                    if(nowLocation == rank.location){
//                        nowRank.value= rank.level+"등"
//                        break
//                    }
//                }
