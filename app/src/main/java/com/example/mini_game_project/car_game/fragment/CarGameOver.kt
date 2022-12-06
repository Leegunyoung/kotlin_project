package com.example.mini_game_project.car_game.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mini_game_project.R
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.databinding.FragmentCarGameOverBinding

class CarGameOver : Fragment() {
    var gameResult: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            gameResult = it.getString("racingResult")
        }
    }
    var binding: FragmentCarGameOverBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarGameOverBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.score?.text=("score:${gameResult}")
        binding?.GoMain?.setOnClickListener {
            findNavController().navigate(R.id.action_carGameOver_to_play)
        }
        binding?.RestartBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_carGameOver_to_carGameView)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }
}