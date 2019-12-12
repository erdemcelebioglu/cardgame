package com.example.okulprojem2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_level1.*


class MainActivity : AppCompatActivity()

{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonlvl1.setOnClickListener {
            val level1Fragment =Level1Fragment()
            val manager =supportFragmentManager
            val transaction =manager.beginTransaction()
            transaction.replace(R.id.fragment,level1Fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }

        buttonlvl2.setOnClickListener {
            val level2Fragment =Level2Fragment()
            val manager =supportFragmentManager
            val transaction =manager.beginTransaction()
            transaction.replace(R.id.fragment,level2Fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }
        buttonlvl3.setOnClickListener {
            val level3Fragment =Level3Fragment()
            val manager =supportFragmentManager
            val transaction =manager.beginTransaction()
            transaction.replace(R.id.fragment,level3Fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }
        buttonlvl4.setOnClickListener {
            val level4Fragment =Level4Fragment()
            val manager =supportFragmentManager
            val transaction =manager.beginTransaction()
            transaction.replace(R.id.fragment,level4Fragment)
            transaction.addToBackStack(null)
            transaction.commit()

        }

        @Override
        fun cardgame(){
            val images :MutableList<Int> = mutableListOf(
                R.drawable.camel,
                R.drawable.camel,
                R.drawable.fox,
                R.drawable.fox,
                R.drawable.wolf,
                R.drawable.wolf
            )
            val buttons = arrayOf(button13,button14,button15,button16,button17,button28)


            val cardBack = R.drawable.stack
            var clicked =0
            var turnOver =false
            var lastClicked =-1


            images.shuffle()

            for (i in 0..5){
                buttons[i].setBackgroundResource(cardBack)
                buttons[i].text ="cardBack"
                buttons[i].textSize=0.0F
                buttons[i].setOnClickListener {
                    if(buttons[i].text=="cardBack" && !turnOver){
                        buttons[i].setBackgroundResource(images[i])
                        buttons[i].setText(images[i])
                        if(clicked==0){
                            lastClicked=i
                        }
                        clicked++
                    }else if (buttons[i].text !in "cardBack"){
                        buttons[i].setBackgroundResource(cardBack)
                        buttons[i].text="cardBack"
                        clicked--
                    }
                    if(clicked==2){
                        turnOver=true
                        if(buttons[i].text==buttons[lastClicked].text){
                            buttons[i].isClickable=false
                            turnOver=false
                            clicked=0
                        }
                        else if(clicked==0){
                            turnOver=false
                        }
                    }
                }
            }

        }

    }





}