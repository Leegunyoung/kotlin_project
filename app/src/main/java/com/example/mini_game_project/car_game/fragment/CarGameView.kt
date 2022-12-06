package com.example.mini_game_project.car_game.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mini_game_project.databinding.FragmentCarGameViewBinding


class CarGameView : Fragment() {
    var binding: FragmentCarGameViewBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCarGameViewBinding.inflate(inflater)
        return context?.let{GameView(it)}
    }
    override fun onDestroyView(){
        super.onDestroyView()
        binding = null
    }

}

