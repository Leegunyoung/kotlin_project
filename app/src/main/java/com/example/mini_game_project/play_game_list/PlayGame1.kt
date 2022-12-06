package com.example.mini_game_project.play_game_list

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.fragment.findNavController
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.FragmentPlayGame1Binding
//import com.example.mini_game_project.main_page.AlarmReceiver

class PlayGame1 : Fragment() {
    var binding:FragmentPlayGame1Binding?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentPlayGame1Binding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnStart?.setOnClickListener{
            findNavController().navigate(R.id.action_play_to_carGameView)
        }
//        binding?.btnAlarm?.setOnClickListener{
//            val intent= Intent(this,AlarmReceiver::class.java)
//            intent.putExtra("message","게임할 시간이에요!")
//            val pendingIntent=PendingIntent.getBroadcast(
//                this,0,intent,PendingIntent.FLAG_IMMUTABLE
//            )
//            getSystemService(AlarmManager::class.java).setExact(
//                AlarmManager.RTC_WAKEUP,
//                SystemClock.elapsedRealtime()+10*1000,
//                pendingIntent
//            )
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
    }


}