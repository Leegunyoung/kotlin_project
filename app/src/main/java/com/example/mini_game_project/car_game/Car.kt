package com.example.mini_game_project.car_game


import android.graphics.drawable.Drawable
import java.util.*

open class Car(private val viewWidth: Int, img: Drawable) {           //이거 car클래스 상속받아서 car1이랑 car2만들었어!
    val carWidth = viewWidth / 8
    val carHeight=carWidth+10
    var carX = 0
    var moveType = 0
    var carY = 0
    var img = img
    var random= Random()
    init {
        random = Random()
        carX = random.nextInt(1000)
        moveType = random.nextInt(2)
    }

    open fun move(){                            //여기가 움직임 나타내주는 함수!
        if(moveType==0){                        //얘는 타입으로 나누어서 대각선으로 왔다 갔다해주려고!
            carX -= 6
            if (carX < -30) {
                moveType = 1
            }
        }
        else if(moveType==1){
            carX += 6
            if (carX > viewWidth - 90) {
                moveType = 0
            }
        }
        carY += 20        //밑으로 내려가는 부분!
    }
}