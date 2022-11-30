package com.example.mini_game_project.main_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.FragmentNicknameBinding
import com.example.mini_game_project.viewmodel.DEFAULT_NAME
import com.example.mini_game_project.viewmodel.NameViewModel

class Nickname : Fragment() {

    var binding : FragmentNicknameBinding? = null
    private val viewModel: NameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNicknameBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 뷰 모델의 observe를 실행시킴으로써 미리 파이어 베이스에 있는 이름들을 array에 넣어줌으로써 중복 검사를 실행해야함, 따로 인터페이스 적으로 보여줄건 없으므로 선언만 해줌
        viewModel.name.observe(viewLifecycleOwner){}

        //확인 버튼을 누르면 setNickname 란에 적힌 이름을 데이터 베이스로 보내줌
        binding?.certainBtn?.setOnClickListener {
            var name = binding?.setNickname?.text.toString()

            // 뷰 모델의 checkName 함수를 이용함
            viewModel.checkName(name)
            Toast.makeText(requireActivity(), "${name}님 환영합니다!", Toast.LENGTH_SHORT).show()

            // 더이상 입력할 수 없도록 함
            postName(false)
        }

        binding?.beforeBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_nickname_and_character_to_mainpage)
        }
    }

    // 이름을 입력하고 확인 버튼을 누르면 더이상 닉네임을 쓸 수 없음
    private fun postName(value: Boolean) {
        binding?.certainBtn?.isEnabled = value
        binding?.setNickname?.isEnabled = value
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}