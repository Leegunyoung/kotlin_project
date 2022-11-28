package com.example.mini_game_project.main_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mini_game_project.databinding.FragmentInviteBinding

class Invite : Fragment() {
    var binding: FragmentInviteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInviteBinding.inflate(inflater,container,false)
        return binding?.root
    }
}