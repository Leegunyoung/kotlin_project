package com.example.mini_game_project.play_game_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.FragmentPlayGame2Binding

class PlayGame2 : Fragment() {

    var binding: FragmentPlayGame2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayGame2Binding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 버튼 이벤트 구현
        binding?.btnStart?.setOnClickListener {
            findNavController().navigate(R.id.action_play_to_numberGame)
        }
    }

}