package com.example.mini_game_project.play_game_list

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mini_game_project.main_page.Play

// FragmentStateAdapter는 생성자로 fragmentActivity를 받기 때문에 어댑터에 생성자로 받아준다.
class PlayPagerAdapter(fragmentActivity: Play):FragmentStateAdapter(fragmentActivity) {

    // 페이지는 총 3장
    override fun getItemCount() = 3

    // 첫 페이지부터 마지막 페이지까지 해당되는 fragment를 정해준다.
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
            // 예외처리
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }
}