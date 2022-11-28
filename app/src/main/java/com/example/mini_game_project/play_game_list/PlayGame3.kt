package com.example.mini_game_project.play_game_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.FragmentPlayGame3Binding

class PlayGame3 : Fragment() {

    var binding: FragmentPlayGame3Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayGame3Binding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.pictureGameBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_play_to_findpicture_game)
        }
    }
}