package com.example.okulprojem2


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.okulprojem2.R.drawable.*

/**
 * A simple [Fragment] subclass.
 */
class Level3Fragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.fragment_level3, container, false)


        val button1 = view?.findViewById<Button>(R.id.button17)
        val button2 = view?.findViewById<Button>(R.id.button18)
        val button3 = view?.findViewById<Button>(R.id.button19)
        val button4 = view?.findViewById<Button>(R.id.button20)
        val button5 = view?.findViewById<Button>(R.id.button21)
        val button6 = view?.findViewById<Button>(R.id.button22)
        val button7 =view?.findViewById<Button>(R.id.button23)
        val button8 =view?.findViewById<Button>(R.id.button24)
        val button9 =view?.findViewById<Button>(R.id.button25)
        val button10 =view?.findViewById<Button>(R.id.button26)
        val button11 =view?.findViewById<Button>(R.id.button27)
        val button12 =view?.findViewById<Button>(R.id.button28)
        val images :MutableList<Int> = mutableListOf(camel, camel, fox, fox, wolf, wolf, coala, coala, monkey, monkey,lion,lion,
            shark,shark)
        val buttons = arrayOf(button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12)


        val cardBack = R.drawable.stack
        var clicked =0
        var turnOver =false
        var lastClicked =-1


        images.shuffle()

        for (i in 0..11){
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
