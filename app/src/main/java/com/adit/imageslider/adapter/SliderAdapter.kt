package com.adit.imageslider.adapter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.adit.imageslider.R

class SliderAdapter(context:Context, color:List<Int>, colorName:List<String>):PagerAdapter(){

    val colors = color
    val contx = context
    val colorNames = colorName

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view  == `object`
    }

    override fun getCount(): Int {
        return colors.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //return super.instantiateItem(container, position)
        val inflater:LayoutInflater = contx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_slider, null)

        val textView = view.findViewById<TextView>(R.id.textView)
        val linearLayout = view.findViewById<ConstraintLayout>(R.id.linearLayout)

        textView.text = colorNames.get(position)
        linearLayout.setBackgroundColor(colors.get(position))

        val viewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //super.destroyItem(container, position, `object`)

        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }

}