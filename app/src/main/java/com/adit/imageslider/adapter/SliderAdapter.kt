package com.adit.imageslider.adapter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adit.imageslider.databinding.DataBinding
import com.adit.imageslider.model.SliderModel

class SliderAdapter(context:Context, data:ArrayList<SliderModel>):PagerAdapter(){

    val data = data
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view  == `object`
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //return super.instantiateItem(container, position)
        val inflater:LayoutInflater = LayoutInflater.from(container.context)
        val binding:DataBinding = DataBinding.inflate(inflater, container, false)
        binding.desc = data.get(position)
        container.addView(binding.root, 0)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //super.destroyItem(container, position, `object`)
        container?.removeView(`object` as ConstraintLayout)
    }

}