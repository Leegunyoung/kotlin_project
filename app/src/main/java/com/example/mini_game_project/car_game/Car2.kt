package com.example.mini_game_project.car_game

import android.graphics.drawable.Drawable
import java.util.*

class Car2(private val viewWidth: Int, img: Drawable): Car(viewWidth, img) {

    init {
        random = Random()
        carX = random.nextInt(1000)
        moveType = random.nextInt(2)
    }

    override fun move(){
        if(moveType==0){
            carX -= 6
            if (carX < -30) {
                moveType = 1
            }
        }
        else if(moveType==1){
            carX +=6
            if (carX > viewWidth - 90) {
                moveType = 0
            }

        }
        carY += 20       //움직임
    }

}