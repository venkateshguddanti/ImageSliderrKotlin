package org.hm.com.imageslider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val items = listOf<SliderItem>(
                SliderItem("one",R.mipmap.ic_launcher),
                SliderItem("one",R.mipmap.ic_launcher),
                SliderItem("one",R.mipmap.ic_launcher),
                SliderItem("one",R.mipmap.ic_launcher),
                SliderItem("one",R.mipmap.ic_launcher),
                SliderItem("one",R.mipmap.ic_launcher)
        )
        slider.setPages(items)
        slider.hideDots()
        //to show grid for hide use hideGrid()
        slider.showGrid()

    }
}
