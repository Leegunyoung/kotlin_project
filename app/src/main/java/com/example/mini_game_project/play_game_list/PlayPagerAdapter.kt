package com.example.mini_game_project.play_game_list

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mini_game_project.main_page.Play

class PlayPagerAdapter(activity: Play):FragmentStateAdapter(activity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                PlayGame1()
            }
            1 -> {
                PlayGame2()
            }
            2 -> {
                PlayGame3()
            }
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }
}