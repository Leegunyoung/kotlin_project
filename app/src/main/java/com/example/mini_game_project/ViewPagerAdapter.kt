package com.example.mini_game_project

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: AppCompatActivity):FragmentStateAdapter(activity) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {Page1Fragment()}
            1 -> {Page2Fragment()}
            2 -> {Page3Fragment()}
            3 -> {Page4Fragment()}
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }
    }
}