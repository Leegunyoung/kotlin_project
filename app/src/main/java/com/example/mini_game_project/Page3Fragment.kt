package com.example.mini_game_project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.databinding.FragmentMainpageBinding
import com.example.mini_game_project.databinding.FragmentPage3Binding
import kotlinx.android.synthetic.main.fragment_page3.*

class Page3Fragment : Fragment() {

    lateinit var binding: FragmentPage3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPage3Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.pictureGameBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_play_to_findpicture_game)
        }
    }
}