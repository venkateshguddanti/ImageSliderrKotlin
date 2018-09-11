package org.hm.com.imageslider.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import org.hm.com.imageslider.GridSelecter
import org.hm.com.imageslider.R
import org.hm.com.imageslider.SliderItem

class GridAdapter(val list : List<SliderItem>, val mListenr : GridSelecter) : RecyclerView.Adapter<GridAdapter.ViewHolder>()
{
    lateinit var context : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            this.context = parent.context
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false))
    }

    override fun getItemCount(): Int {

        return list.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(!list.get(position).url.equals(""))
        {
            holder.icon.setImageURI(Uri.parse(list.get(position).url), context)

        }
        list.get(position).resId?.let {

            val path = "res:/" + list.get(position).resId // Only one slash after res:
            holder.icon.setImageURI(Uri.parse(path),context)

        }
        holder.icon.setOnClickListener(View.OnClickListener {

            mListenr.onItemSelect(position)
        })
    }

    class ViewHolder : RecyclerView.ViewHolder
    {
          val icon : SimpleDraweeView
          constructor(itemView : View) : super(itemView)
          {
              icon = itemView.findViewById(R.id.gridicon)
          }

    }
}