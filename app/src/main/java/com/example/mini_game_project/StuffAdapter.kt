package com.example.mini_game_project

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_game_project.databinding.ListStuffBinding
import kotlin.concurrent.timerTask

class StuffAdapter(val stuffList: MutableList<Stuff>)
    : RecyclerView.Adapter<StuffAdapter.Holder>() {

    private var clickItemIndexList = arrayListOf<Int>()
    private var num = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ListStuffBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(stuffList[position], position)
    }

    override fun getItemCount() : Int = stuffList.size

    inner class Holder(private val binding: ListStuffBinding): RecyclerView.ViewHolder(binding.root){

        @SuppressLint("NotifyDataSetChanged")
        fun bind(what: Stuff, position: Int){
            binding.presentBtn.setImageResource(when(what.things){
                Kindof.CHRISTMASTREE -> R.drawable.christmastree
                Kindof.SANTA -> R.drawable.santa
                Kindof.REINDEER -> R.drawable.reindeer
                Kindof.SNOWMAN -> R.drawable.snowman
            })

            if(what.clickFlag) {
                binding.giftBtn.visibility = View.VISIBLE
            } else {
                binding.giftBtn.visibility = View.GONE
            }

            binding.giftBtn.setOnClickListener {
                stuffList[position].clickFlag = false

                clickItemIndexList.add(position)
//                Log.d("StuffAdapter", "현재 POSITION: ${position}")
//                Log.d("StuffAdapter", "클릭인덱스리스트: ${clickItemIndexList.size}")

                if(clickItemIndexList.size == 2){
                    if(stuffList[clickItemIndexList[0]].things.name != stuffList[clickItemIndexList[1]].things.name) {
                        Handler(Looper.getMainLooper()).postDelayed({
                            stuffList[clickItemIndexList[0]].clickFlag = true
                            stuffList[clickItemIndexList[1]].clickFlag = true
                            clickItemIndexList.clear()
                            notifyDataSetChanged()
                        }, 1000)
                    }
                    else{
                        num++
                        clickItemIndexList.clear()
                    }
                }
                notifyDataSetChanged()

                if(num == 8){
                    Toast.makeText(MainApplication.applicationContext(),"game over", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}