package com.example.mini_game_project

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.guide.*
import kotlinx.android.synthetic.main.play.*


class Play : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play)

        return_to.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout,viewPager){tab,index ->
            tab.text = when(index){
                0 -> {"부릉!부릉!"}
                1 -> {"2048"}
                2 -> {"Black Jack"}
                3 -> {"가위! 바위! 보!"}
                else -> {throw Resources.NotFoundException("Position Not Found")
                }
            }
        }.attach()
    }
}
