package org.hm.com.imageslider

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.slider_content.view.*
import org.hm.com.imageslider.adapter.GridAdapter
import org.hm.com.imageslider.adapter.SliderAdapter


class ImageSlider @JvmOverloads constructor(context: Context, attributeSet: AttributeSet):RelativeLayout(context,attributeSet),GridSelecter
{
    override fun onItemSelect(position: Int) {
        pager.currentItem = position
    }


    var root : View
    var pager : ViewPager
    lateinit var gridList : RecyclerView
    var dotsLayout : TabLayout
    lateinit var mSliderAdapter : SliderAdapter;
    lateinit var mGridAdapter : GridAdapter;
     var sliderItms : MutableList<SliderItem>

    init {

        sliderItms = mutableListOf();
        root = View.inflate(context,R.layout.slider_content,this)
        pager = root.findViewById(R.id.pager)
        dotsLayout = root.findViewById(R.id.tab_layout)
        gridList = root.findViewById(R.id.grid)




    }



    fun setPages(sliderItems: List<SliderItem>)
    {
        this.sliderItms.clear()
        this.sliderItms.addAll(sliderItems)
        mSliderAdapter = SliderAdapter((context as FragmentActivity).supportFragmentManager, sliderItems);

        if(sliderItems.size > 0)
        {
            pager.adapter = mSliderAdapter
            pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
            pager.offscreenPageLimit = sliderItems.size
        }
        dotsLayout.setupWithViewPager(pager, true);



    }
    fun hideDots()
    {
        dotsLayout.visibility = View.GONE
    }
    fun showGrid()
    {
        gridList.visibility = View.VISIBLE
        gridList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mGridAdapter = GridAdapter(this.sliderItms, this)
        gridList.adapter = mGridAdapter
    }
    fun hideGrid()
    {
        gridList.visibility = View.VISIBLE
    }
    fun showTitle()
    {

    }
    fun hideTitle()
    {

    }


}