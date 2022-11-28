package com.example.mini_game_project.rank_page_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.RecRankBinding
import com.example.mini_game_project.viewmodel.DEFAULT_RANK

class RankAdapter(val user: LiveData<List<User>>)
    : RecyclerView.Adapter<RankAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding = RecRankBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(user.value?.get(position) ?: DEFAULT_RANK)
    }

    override fun getItemCount() = user.value?.size ?: 0

    class  Holder(private val binding: RecRankBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User){
            binding.imgMedal.setImageResource(when(user.level) {
                "1" -> R.drawable.gold
                "2" -> R.drawable.silver
                "3" -> R.drawable.bronze
                else -> R.drawable.socks
            })
            binding.txtName.text = user.name
            binding.txtLevel.text = user.level
            binding.txtTime.text = user.time.toString()
        }
    }
}