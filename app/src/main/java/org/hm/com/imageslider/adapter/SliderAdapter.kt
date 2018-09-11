package org.hm.com.imageslider.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import org.hm.com.imageslider.SliderFragment
import org.hm.com.imageslider.SliderItem

class SliderAdapter(fm : FragmentManager,sliderItems : List<SliderItem>) : FragmentPagerAdapter(fm)
{
    val sliderItems : List<SliderItem> = sliderItems;

    override fun getItem(position: Int): Fragment {

        return SliderFragment.newInstance(sliderItems.get(position))
    }

    override fun getCount(): Int {

        return sliderItems.size
    }


}