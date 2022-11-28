package com.example.mini_game_project.rank_page_list

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.fragment_find_picture_rank.*
import com.example.mini_game_project.main_page.Rank

class RankPagerAdapter(activity: Rank): FragmentStateAdapter(activity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                CarGameRank()
            }
            1 -> {
                FindPictureRank()
            }
            2 -> {
                NumberRank()
            }
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }
}