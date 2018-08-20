package com.adit.imageslider

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.adit.imageslider.adapter.SliderAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    var viewPager:ViewPager? = null
    var indicator:TabLayout? = null

    val color = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        indicator = findViewById(R.id.indicator)

        color.add(Color.RED)
        color.add(Color.GREEN)
        color.add(Color.BLUE)

        val colorName = ArrayList<String>()
        colorName.add("RED")
        colorName.add("GREEN")
        colorName.add("BLUE")

        viewPager!!.adapter = SliderAdapter(this, color, colorName)
        indicator!!.setupWithViewPager(viewPager, true)

        val timer = Timer()
        timer.scheduleAtFixedRate(SliderTimer(), 4000, 6000)
    }


    inner class SliderTimer:TimerTask(){
        override fun run() {
            runOnUiThread {
                run{
                    if (viewPager!!.currentItem < color.size - 1)
                        viewPager!!.setCurrentItem(viewPager!!.currentItem + 1)
                    else
                        viewPager!!.setCurrentItem(0)
                }
            }
        }

    }
}
