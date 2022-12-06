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

        // 메인으로 돌아가는 버튼
        binding?.btnPlayToMain?.setOnClickListener {
            findNavController().navigate(R.id.action_play_to_mainpage)
        }

        // viewPager에는 바인딩된 viewPager layout을 tabLayout에는 바인딩된 tabLayout을 넣어준다.
        viewPager = binding?.viewPager1!!
        tabLayout = binding?.tabLayout1!!

        // viewpager의 어뎁터로 이전에 만들어놓은 PlayPagerAdaper를 연결해준다.
        viewPager.adapter = PlayPagerAdapter(this)

        // TabLayoutMediator를 사용하여서 각 tab의 text와 index을 매칭 시킨 후 attach 하면 같이 슬라이드 되는 레이아웃 만들어짐
        TabLayoutMediator(tabLayout,viewPager){tab,index ->
            tab.text = when(index){
                0 -> "Car Game"
                1 -> "Number Game"
                2 -> "Same Picture"
                else -> {throw Resources.NotFoundException("Position Not Found")
                }
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}