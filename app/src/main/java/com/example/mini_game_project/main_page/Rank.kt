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
import com.example.mini_game_project.rank_page_list.RankPagerAdapter
import com.example.mini_game_project.databinding.FragmentRankBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Rank : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    var binding : FragmentRankBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRankBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.returnRankToMain?.setOnClickListener {
            findNavController().navigate(R.id.action_rank_to_mainpage)
        }

        viewPager = binding?.viewPager2!!
        tabLayout = binding?.tabLayout2!!

        viewPager.adapter = RankPagerAdapter(this)

        TabLayoutMediator(tabLayout,viewPager){tab,index ->
            tab.text = when(index){
                0 -> {"Car Game"}
                1 -> {"Same Picture"}
                2 -> {"Number Game"}
                else -> {throw Resources.NotFoundException("Position Not Found")
                }
            }
        }.attach()
    }

}