package com.example.mini_game_project.picture_game

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_game_project.R
import com.example.mini_game_project.databinding.RecStuffBinding

class StuffAdapter(val stuffList: MutableList<Stuff>, private val callback: StuffAdapterCallback)
    : RecyclerView.Adapter<StuffAdapter.Holder>() {

    private var clickItemIndexList = arrayListOf<Int>() //해당 포지션에 있는 enum class의 name이 같은지 다른지 확인하기 위한 리스트
    private var num = 0     // 8쌍이 나왔는지 확인하기 위함


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder { //inflater
        val binding = RecStuffBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding, callback)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(stuffList[position], position)  //리스트와 그 리스트 인덱스 바인딩
    }

    override fun getItemCount() : Int = stuffList.size  //객체 리스트의 사이즈

    inner class Holder(private val binding: RecStuffBinding, callback: StuffAdapterCallback): RecyclerView.ViewHolder(binding.root){

        @SuppressLint("NotifyDataSetChanged")
        fun bind(what: Stuff, position: Int){   //Stuff 클래스에 그림을 넣어줌, 포지션은 해당 객체의 위치 파악을 위함
            binding.presentBtn.setImageResource(when(what.things){
                Kindof.CHRISTMASTREE -> R.drawable.christmastree
                Kindof.SANTA -> R.drawable.santa
                Kindof.REINDEER -> R.drawable.reindeer
                Kindof.SNOWMAN -> R.drawable.snowman
                Kindof.SNOW -> R.drawable.snow
                Kindof.WREATH -> R.drawable.wreath
                Kindof.SOCKS -> R.drawable.socks
                Kindof.FIREPALCE -> R.drawable.fireplace
            })

            //giftbutton이 ture일시 보임, false 일시 안보임(없어짐)
            if(what.clickFlag) binding.giftBtn.visibility = View.VISIBLE else binding.giftBtn.visibility = View.GONE

            // 선물 버튼 클릭시 발생하는 이벤트 구현
            binding.giftBtn.setOnClickListener {
                stuffList[position].clickFlag = false   //클릭하면 stuffList의 해당 포지션의 giftbtn false

                clickItemIndexList.add(position)    //해당 포지션을 리스트에 저장해줌

                if(clickItemIndexList.size == 2){   //두 개의 선물상자 클릭시
                    checkGift(stuffList[clickItemIndexList[0]], stuffList[clickItemIndexList[1]])
                }

                notifyDataSetChanged()  //이를 알려줌

                // 8쌍을 모두 찾으면 콜백함수 부름
                if(num == 8){
                    // 콜백 함수를 호출해준다.
                    callback.onGameOverCallback()
                }
            }
        }
    }

    // enum 클래스의 프로퍼티인 name에 접근해 선물상자 개봉시 두 객체가 같은지 여부를 확인함
    fun checkGift(stuff1: Stuff, stuff2: Stuff) {

        //해당 리스트의 객체 이름이 다를시
        if (stuff1.things.name != stuff2.things.name) {

            //딜레이 발생을 위해 postDelayed 안에 구현, 0.8초 동안 보여주고 다시 선물 버튼을 덮어놓는다.
            Handler(Looper.getMainLooper()).postDelayed({
                stuff1.clickFlag = true   // 둘 다 true로 바꾼다 -> 선물 버튼이 다시 덮힘
                stuff2.clickFlag = true   // 둘 다 true로 바꾼다 -> 선물 버튼이 다시 덮힘
                notifyDataSetChanged()  //데이터에 변화가 있다는 것을 알리세요!
            }, 800)    //0.8 초의 딜레이

        } else {   // 해당 포지션 객체의 이름이 맞을 시
            num++   // 모든 giftbtn이 없어졌는지 확인하기 위함
        }
        clickItemIndexList.clear()  //포지션 리스트를 비워줌
    }
}