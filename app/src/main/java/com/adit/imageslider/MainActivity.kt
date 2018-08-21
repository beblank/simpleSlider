package com.adit.imageslider

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.adit.imageslider.adapter.SliderAdapter
import com.adit.imageslider.model.SliderModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    var viewPager:ViewPager? = null
    var indicator:TabLayout? = null

    val data = ArrayList<SliderModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        indicator = findViewById(R.id.indicator)

        data.add(SliderModel(Color.RED, "RED"))
        data.add(SliderModel(Color.GREEN, "GREEN"))
        data.add(SliderModel(Color.BLUE, "BLUE"))

        viewPager!!.adapter = SliderAdapter(this, data)
        indicator!!.setupWithViewPager(viewPager, true)

        val timer = Timer()
        timer.scheduleAtFixedRate(SliderTimer(), 4000, 6000)
    }


    inner class SliderTimer:TimerTask(){
        override fun run() {
            runOnUiThread {
                run{
                    if (viewPager!!.currentItem < data.size - 1)
                        viewPager!!.setCurrentItem(viewPager!!.currentItem + 1)
                    else
                        viewPager!!.setCurrentItem(0)
                }
            }
        }

    }
}
