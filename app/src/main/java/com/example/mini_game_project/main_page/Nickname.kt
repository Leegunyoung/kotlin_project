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
    val viewModel: NameViewModel by activityViewModels()

    var name: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = viewModel.name.value
        }
    }

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

        viewModel.name.observe(viewLifecycleOwner){
            if(name != "") {
                binding?.setNickname?.setText(name + "입니다.")
            }else{
                binding?.setNickname?.setText("")
            }
        }

        binding?.certainBtn?.setOnClickListener {
            val name = binding?.setNickname?.text.toString()
            viewModel.tryName(name)
            Toast.makeText(requireActivity(), "${name}님 환영합니다!", Toast.LENGTH_SHORT).show()
            postName(false)
        }

        binding?.beforeBtn?.setOnClickListener {
            findNavController().navigate(R.id.action_nickname_and_character_to_mainpage)
        }
    }

    private fun postName(value: Boolean) {
        binding?.certainBtn?.isEnabled = value
        binding?.setNickname?.isEnabled = value
    }
}