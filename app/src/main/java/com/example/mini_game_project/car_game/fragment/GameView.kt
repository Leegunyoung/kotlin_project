package com.example.mini_game_project.car_game.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.view.MotionEvent
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.mini_game_project.*
import com.example.mini_game_project.car_game.Car
import com.example.mini_game_project.car_game.Car1
import com.example.mini_game_project.car_game.Car2
import com.example.mini_game_project.car_game.RacingPlayer
import java.util.*
import kotlin.concurrent.timer

class GameView(c: Context) : View(c) {
    var myPaint= Paint()
    var cars = mutableListOf<Car>()                          //car들 담을 배열 빈배열에 하나씩 추가하려고!수정하려고!
    var score = 0
    private var viewWidth = 0                                //화면 넓이
    private var viewHeight = 0                               //화면 넓이
    private lateinit var racingPlayer: RacingPlayer          //이거 모르겠어
    private val racingPlayerImg: Drawable
    private val car2Img : Drawable                          //첫번째 장애물
    private val car3Img : Drawable                          //두번째 장애물
    private var random: Random = Random()
    private var playerPosition=0                              //player 위치

    init{
        cars= mutableListOf()
        racingPlayerImg = resources.getDrawable(R.drawable.car,null)
        car2Img=resources.getDrawable(R.drawable.car2,null)
        car3Img=resources.getDrawable(R.drawable.car3,null)
        createCars()                           //차들 timer 시간에 따라서 생성되어 배열에 들어간다!
    }
    private fun createCars() {
        timer(period = 400) {
            var randomCar = random.nextInt(2)              //random하게 배열에 넣어주기 why?두 차 속도다르게하려고!

            if (randomCar == 0) {
                var car1 = Car1(viewWidth, car2Img)                //car객체에 넣어주기
                cars.add(car1)
            }
            else {
                var car2 = Car2(viewWidth, car3Img)
                cars.add(car2)
            }
        }
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        background = if(score>10){
            resources.getDrawable(R.drawable.sea,null)
        }
        else if(score>20){
            resources.getDrawable(R.drawable.desert,null)
        }
        else {
            resources.getDrawable(R.drawable.road, null)
        }
            viewWidth=this.measuredWidth                       //가로 길이 구해서 차량 서있는 위치 나타나주기
            viewHeight=this.measuredHeight                     //세로 길이 구해서 차량 서있는 위치 나타내주기
            racingPlayer= RacingPlayer(viewWidth,racingPlayerImg)

            racingPlayer.img.setBounds(                                                   //내가 조종하고 있는 차의 위치잡기
                viewWidth/15+25+playerPosition,         //x1
                viewHeight-racingPlayer.carHeight,                              //y1
                viewWidth/15+racingPlayer.carWidth-25+playerPosition, //x2
                viewHeight                                                 //y2
            )
            racingPlayer.img.draw(canvas)                                      //!!일떄만 코드가 먹음 null값이 없다라고 가정했을때만

            for(i in cars.indices.reversed()){                         //여기가 이제 그려주는 부분으로 draw할때마다 move로 달라진 값 좌표찍어서 그려줘!
            cars[i].move()
            try{
                cars[i].img.setBounds(
                    cars[i].carX+25,cars[i].carY-cars[i].carHeight,cars[i].carX+cars[i].carWidth-25, cars[i].carY)
                cars[i].img.draw(canvas)


                if(cars[i].carY > viewHeight){                 //밑으로 내려가면 없어지고 점수 1더해줘
                    cars.removeAt(i)
                    score += 1
                }

                else if(cars[i].carX+cars[i].carWidth-25>playerPosition+viewWidth/15+25           //충돌체크하는 부분
                        && cars[i].carX+25<playerPosition+viewWidth/15+cars[i].carWidth-25){

                    if(cars[i].carY > viewHeight - cars[i].carHeight && cars[i].carY < viewHeight){
                        var bundle= bundleOf("racingResult" to score.toString())

                        findNavController().navigate(R.id.action_carGameView_to_carGameOver,bundle)
                    }
                }
            }
            catch (e:Exception){
                e.printStackTrace()
            }
            }
        myPaint.color= Color.RED
        myPaint.textSize=40f
        canvas.drawText("Score:$score",80f,80f,myPaint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                val x1=event.x
                if(x1<viewWidth/2){
                    if(playerPosition < 0){
                        playerPosition = 0
                    }
                    else{
                        playerPosition -=90
                    }
                }
                if(x1>viewWidth/2){
                    if(playerPosition>viewWidth-90){
                        playerPosition=viewWidth-90
                    }
                    else{
                        playerPosition+=90
                    }
                }
            }
            MotionEvent.ACTION_UP->{
            }
        }
        return true
    }
}