package com.example.mini_game_project.main_page

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.mini_game_project.R
import com.example.mini_game_project.play_game_list.PlayPagerAdapter
import com.example.mini_game_project.databinding.FragmentPlayBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Play : Fragment() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    var binding : FragmentPlayBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.returnPlayToMain?.setOnClickListener {
            findNavController().navigate(R.id.action_play_to_mainpage)
        }

        viewPager = binding?.viewPager1!!
        tabLayout = binding?.tabLayout1!!

        viewPager.adapter = PlayPagerAdapter(this)

        TabLayoutMediator(tabLayout,viewPager){tab,index ->
            tab.text = when(index){
                0 -> {"Car Game"}
                1 -> {"Number Game"}
                2 -> {"Same Picture"}
                else -> {throw Resources.NotFoundException("Position Not Found")
                }
            }
        }.attach()
    }
}