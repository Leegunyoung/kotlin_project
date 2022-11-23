package com.example.mini_game_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mini_game_project.databinding.FragmentFindpictureGameBinding
import java.util.Collections.shuffle

class FindpictureGame : Fragment() {

    var binding: FragmentFindpictureGameBinding? = null  //fragment의 binding을 초기화

    lateinit var things: ArrayList<Stuff>   //Stuff이라는 것을 넣은 array로 초기화, 우선 그림파일을 넣어둠. 버튼으로 어떻게 넣어줄건지 생각요함

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindpictureGameBinding.inflate(inflater,container,false)  //fragment에서 기본적인 초기화 진행

        //카드를 언제 넣어줄 것인가?
        things = arrayListOf<Stuff>(
            Stuff(Kindof.CHRISTMASTREE, true),
            Stuff(Kindof.REINDEER, true),
            Stuff(Kindof.SANTA, true),
            Stuff(Kindof.SNOWMAN, true),
            Stuff(Kindof.CHRISTMASTREE, true),
            Stuff(Kindof.REINDEER, true),
            Stuff(Kindof.SANTA, true),
            Stuff(Kindof.SNOWMAN, true),
            Stuff(Kindof.CHRISTMASTREE, true),
            Stuff(Kindof.REINDEER, true),
            Stuff(Kindof.SANTA, true),
            Stuff(Kindof.SNOWMAN, true),
            Stuff(Kindof.CHRISTMASTREE, true),
            Stuff(Kindof.REINDEER, true),
            Stuff(Kindof.SANTA, true),
            Stuff(Kindof.SNOWMAN, true)
        )
        things.shuffle()

        init()  //함수를 통해 셔플 진행

        binding?.recStuff?.layoutManager = GridLayoutManager(activity,4) //gridlayout을 통해 4x4로 나눠서 보여줌
        binding?.recStuff?.adapter = StuffAdapter(things) // 생성해준 stuff 객체 adapter 적용
        return binding?.root
    }

    private fun init(){ //셔플될때 마다 flag를 true로 바꿔 준 다음 다시 셔플 시작

        binding?.resetBtn?.setOnClickListener {

            for (i in things){
                i.clickFlag = true
            }

            things.shuffle()
            binding?.recStuff?.adapter = StuffAdapter(things)
        }
    }

    override fun onPause(){
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}

