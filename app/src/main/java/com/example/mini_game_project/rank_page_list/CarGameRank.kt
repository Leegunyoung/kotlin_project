package com.example.mini_game_project.rank_page_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.FragmentCarGameRankBinding

class CarGameRank : Fragment() {

    var binding: FragmentCarGameRankBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarGameRankBinding.inflate(inflater)
        return binding?.root
    }
}