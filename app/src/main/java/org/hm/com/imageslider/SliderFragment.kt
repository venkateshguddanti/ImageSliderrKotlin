package org.hm.com.imageslider

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.common.util.UriUtil
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.slider_item_container.view.*


class SliderFragment : Fragment()
{
    lateinit var sliderItem: SliderItem
    lateinit var fragView: View

    companion object {
        fun  newInstance(item : SliderItem) : SliderFragment
        {
            val fragmet = SliderFragment()
            val args= Bundle()
            args.putParcelable(SliderItem::class.java.simpleName,item)
            fragmet.arguments = args
            return fragmet

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragView = inflater.inflate(R.layout.slider_item_container,container,false)
        sliderItem = arguments!!.getParcelable(SliderItem::class.java.simpleName)
        initViews()

        return fragView
    }

     fun initViews() {

            if(!sliderItem.title.equals(""))
            {
                fragView.title_layout.visibility = View.VISIBLE
                fragView.title.setText(sliderItem.title)
            }else
            {
                fragView.title_layout.visibility = View.GONE
            }


            if(!sliderItem.url.equals(""))
            {
                fragView.img.setImageURI(Uri.parse(sliderItem.url),context)
            }
            sliderItem.resId?.let {

                val path = "res:/" + sliderItem.resId // Only one slash after res:
                fragView.img.setImageURI(Uri.parse(path),context)

            }
           }

    fun showTitle()
    {
        fragView.title_layout.visibility = View.VISIBLE
    }
    fun hideTitle()
    {
        fragView.title_layout.visibility = View.GONE
    }
}