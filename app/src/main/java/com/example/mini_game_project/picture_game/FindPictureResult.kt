package com.example.mini_game_project.picture_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.FragmentFindPictureResultBinding

class FindPictureResult : Fragment() {

    var binding: FragmentFindPictureResultBinding? = null

    private var gameResult: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 게임 프레그먼트에서 보내온 번들(게임결과)을 gameResult에 넣어준다.
        arguments?.run {
            gameResult = getString("Time")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindPictureResultBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 결과를 넣어줌
        binding?.txtPicResult?.text = gameResult

        binding?.btnPicRegame?.setOnClickListener {
            findNavController().navigate(R.id.action_samepictureRank_to_play)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}