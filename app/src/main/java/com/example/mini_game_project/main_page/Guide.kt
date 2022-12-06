package com.example.mini_game_project.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.mini_game_project.databinding.FragmentGuideBinding

class Guide : DialogFragment() {
    private var _binding: FragmentGuideBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGuideBinding.inflate(inflater, container, false)

        binding?.closeBtn?.setOnClickListener {
            dismiss()      //클릭시 닫힘
        }
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
