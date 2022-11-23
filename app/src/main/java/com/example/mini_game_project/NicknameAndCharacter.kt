package com.example.mini_game_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.databinding.FragmentNicknameAndCharacterBinding

class NicknameAndCharacter : Fragment() {

    var binding : FragmentNicknameAndCharacterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNicknameAndCharacterBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.nicknameButton?.setOnClickListener {
            findNavController().navigate(R.id.action_nickname_and_character_to_mainpage)
        }
    }
}