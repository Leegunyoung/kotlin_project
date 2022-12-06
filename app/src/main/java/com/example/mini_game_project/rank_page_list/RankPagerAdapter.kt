package com.example.mini_game_project.rank_page_list

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mini_game_project.main_page.Rank
import com.example.mini_game_project.number_game.NumberResult
import com.example.mini_game_project.picture_game.FindPictureResult

class RankPagerAdapter(fragmentActivity: Rank): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                CarGameRank()
            }
            1 -> {
                FindPictureResult()
            }
            2 -> {
                NumberResult()
            }
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }
}