package com.example.mini_game_project.picture_game

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.FragmentFindPictureGameBinding

class FindPictureGame : Fragment(), StuffAdapterCallback {

    var binding: FragmentFindPictureGameBinding? = null  //fragment의 binding을 초기화

    var timeFlow : Long = 0L     //시간 기록을 위한 변수

    lateinit var things: ArrayList<Stuff>   //Stuff이라는 것을 넣은 array로 초기화, 우선 그림파일을 넣어둠. 버튼으로 어떻게 넣어줄건지 생각요함

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindPictureGameBinding.inflate(inflater,container,false)  //fragment에서 기본적인 초기화 진행

        //카드를 언제 넣어줄 것인가?
        things = arrayListOf<Stuff>(        //arraylist에 stuff 객체를 생성해 넣어주자
            Stuff(Kindof.CHRISTMASTREE, true),
            Stuff(Kindof.REINDEER, true),
            Stuff(Kindof.SANTA, true),
            Stuff(Kindof.SNOWMAN, true),
            Stuff(Kindof.SNOW, true),
            Stuff(Kindof.FIREPALCE, true),
            Stuff(Kindof.SOCKS, true),
            Stuff(Kindof.WREATH, true),
            Stuff(Kindof.CHRISTMASTREE, true),
            Stuff(Kindof.REINDEER, true),
            Stuff(Kindof.SANTA, true),
            Stuff(Kindof.SNOWMAN, true),
            Stuff(Kindof.SNOW, true),
            Stuff(Kindof.FIREPALCE, true),
            Stuff(Kindof.SOCKS, true),
            Stuff(Kindof.WREATH, true)
        )
        things.shuffle()    // 게임 시작 전 바로 셔플 진행

        init()  //함수를 통해 셔플 진행
        binding?.timer?.start() // 타이머 시작

        binding?.recStuff?.layoutManager = GridLayoutManager(activity,4) //gridlayout을 통해 4x4로 나눠서 보여줌
        binding?.recStuff?.adapter = StuffAdapter(things, this) // 생성해준 stuff 객체 adapter 적용

        return binding?.root
    }

    private fun init(){ //셔플될때 마다 flag를 true로 바꿔 준 다음 다시 셔플 시작

        binding?.resetBtn?.setOnClickListener { // 리셋버튼 터치 구현
            for (i in things){  //모두 true로 바꿔 준 후
                i.clickFlag = true
            }
            things.shuffle()      // 셔플 진행
            binding?.recStuff?.adapter = StuffAdapter(things, this)   //다시 어뎁터를 통해 선물상자를 씌워줌

            binding?.timer?.base = SystemClock.elapsedRealtime()       //시간 초기화
            binding?.timer?.start()     // 타이머 시작
        }
    }

    // 인터페이스의 콜백 함수 구현, 이를 통해 어뎁터로 보내는 징검다리 역할을 해줌
    override fun onGameOverCallback() {
        // 게임을 완료하는데 걸린 시간을 계산하기 위함
        timeFlow = SystemClock.elapsedRealtime() - binding?.timer?.base!!.toLong()

        // 사용자에게 몇분 몇초가 걸렸는지 보여줌
        Toast.makeText(requireActivity(),
            "${timeFlow/6000}분 ${(timeFlow/1000%60)}초",
            Toast.LENGTH_LONG).show()

        //바로 랭킹 페이지로 이동하게 함
        findNavController().navigate(R.id.action_findpicture_game_to_samepictureRank)
    }

    fun gameScore(){
        // 모두 다 뒤집혔는지 확인
        var tf = true

        // 객체 모두를 순회해 giftbtn이 모두 없어졌다면 tf는 true
        for (i in 0 until things.size){
            if(things[i].clickFlag){
                tf = false
            }
        }
        // tf 가 true면 데이터 베이스와 리스트에 넣어줌
        if (tf){
            timeFlow = SystemClock.elapsedRealtime() - binding?.timer?.base!!.toLong()

        }
    }

    override fun onDestroyView(){  //파괴자
        super.onDestroyView()
        binding = null
    }
}

/*
이제 해야할 것
하나의 코드에 합치기,
연미: 숫자게임
건영: 자동차 게임
승현: 그림 맞추기 게임
게임의 결과를 파이어 베이스에 보내되 유저 이름의 child로 들어가게 해야할 것,
각각의 유저의 이름에는 각각의 게임 기록이 남아있어야함
또한 recycleview를 통해 이를 랭킹으로 구현해야함, 게임마다 랭킹페이지 만들어야 함.
 */

