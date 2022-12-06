package com.example.mini_game_project.number_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.FragmentNumberResultBinding

class NumberResult : Fragment() {

    private var gameResult: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            gameResult = it.getString("SCORE")
        }
    }

    var binding: FragmentNumberResultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumberResultBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.txtNumResult?.text = gameResult

        val bundle = Bundle().apply { }

        binding?.btnNumRegame?.setOnClickListener {
            findNavController().navigate(R.id.action_numberResult_to_numberGame, bundle)
        }
        binding?.GoMain2?.setOnClickListener {
            findNavController().navigate(R.id.action_numberResult_to_play, bundle)
        }
    }
}