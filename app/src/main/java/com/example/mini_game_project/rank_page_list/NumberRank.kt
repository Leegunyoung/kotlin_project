package com.example.mini_game_project.rank_page_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mini_game_project.databinding.FragmentNumberRankBinding

class NumberRank : Fragment() {

    var binding : FragmentNumberRankBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumberRankBinding.inflate(inflater)
        return binding?.root
    }
}