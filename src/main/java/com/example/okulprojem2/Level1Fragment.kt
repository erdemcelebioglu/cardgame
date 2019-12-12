package com.example.okulprojem2



import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.okulprojem2.R.drawable.*


class Level1Fragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_level1, container, false)


        val button1 = view?.findViewById<Button>(R.id.button13)
        val button2 = view?.findViewById<Button>(R.id.button14)
        val button3 = view?.findViewById<Button>(R.id.button15)
        val button4 = view?.findViewById<Button>(R.id.button16)
        val button5 = view?.findViewById<Button>(R.id.button17)
        val button6 = view?.findViewById<Button>(R.id.button28)
        val images :MutableList<Int> = mutableListOf(
            camel, camel, fox, fox,wolf,wolf)
        val buttons = arrayOf(button1,button2,button3,button4,button5,button6)


        val cardBack =stack
        var clicked =0
        var turnOver =false
        var lastClicked =-1


        images.shuffle()

        for (i in 0..5){
            buttons[i]!!.setBackgroundResource(cardBack)
            buttons[i]!!.text ="cardBack"
            buttons[i]!!.textSize=0.0F
            buttons[i]!!.setOnClickListener {
                if(buttons[i]!!.text=="cardBack" && !turnOver){
                    buttons[i]!!.setBackgroundResource(images[i])
                    buttons[i]!!.setText(images[i])
                    if(clicked==0){
                        lastClicked=i
                    }
                    clicked++
                }else if (buttons[i]!!.text !in "cardBack"){
                    buttons[i]!!.setBackgroundResource(cardBack)
                    buttons[i]!!.text="cardBack"
                    clicked--
                }
                if(clicked==2){
                    turnOver=true
                    if(buttons[i]!!.text==buttons[lastClicked]!!.text){
                        buttons[i]!!.isClickable=false
                        turnOver=false
                        clicked=0
                    }
                }
                    else if(clicked==0){
                        turnOver=false
                    }
                }
            }



        return view




    }






}


