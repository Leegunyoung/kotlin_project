package com.example.mini_game_project.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.FragmentMainPageBinding

class MainPage : Fragment() {

    var binding: FragmentMainPageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.rankBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_mainpage_to_rank2)
        }
        binding?.playBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_mainpage_to_play2)
        }
        binding?.nicknameBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_mainpage_to_nickname_and_character)
        }
        binding?.inviteBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_mainpage_to_invite22)
        }
        binding?.guideBtn?.setOnClickListener {
            Guide().show(requireActivity().supportFragmentManager, "tag")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}