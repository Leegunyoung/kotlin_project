package com.example.mini_game_project.rank_page_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mini_game_project.databinding.FragmentFindPictureRankBinding
import com.example.mini_game_project.viewmodel.PictureViewModel
import com.example.mini_game_project.picture_game.StuffAdapterCallback

class FindPictureRank : Fragment(){


    var binding: FragmentFindPictureRankBinding? = null
    val viewModel: PictureViewModel by activityViewModels()

    lateinit var users : LiveData<List<User>>
//    lateinit var nowRank : LiveData<String>
//    lateinit var lastRank : LiveData<String>

    private val students = users

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            time = it.getInt("time")  // 게임 프래그먼트에서 보낸 값이 여기로 전달된다
//            name = it.getInt("name")
//            ranks = viewModel.rank
//            nowRank = viewModel.nowRank
//            lastRank = viewModel.last
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindPictureRankBinding.inflate(inflater, container, false)
        binding?.recRank?.layoutManager = LinearLayoutManager(requireActivity())
        binding?.recRank?.adapter = RankAdapter(students)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Ranking 실시간 업데이트
        viewModel.rank.observe(viewLifecycleOwner) {
            binding?.recRank?.layoutManager = LinearLayoutManager(this.context)
            binding?.recRank?.adapter = RankAdapter(users)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}