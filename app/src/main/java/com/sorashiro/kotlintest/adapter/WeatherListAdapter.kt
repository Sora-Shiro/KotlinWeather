package com.sorashiro.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sorashiro.kotlintest.R
import com.sorashiro.kotlintest.tools.ctx

class WeatherListAdapter (val context: Context, val items: List<String>, val onItemClickListener: OnItemClickListener) :
        RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int, city: String)
        fun onItemLongClick(view: View, position: Int, city: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent!!.ctx).inflate(R.layout.item_city, parent, false)
        val viewHolder: ViewHolder = ViewHolder(itemView)
        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val city = items[position]

        viewHolder.textView.text = city

        viewHolder.view.setOnClickListener {
            onItemClickListener.onItemClick(viewHolder.view, position, city)
        }
        viewHolder.view.setOnLongClickListener {
            onItemClickListener.onItemLongClick(viewHolder.view, position, city)
            true
        }
    }

    override fun getItemCount() = items.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById(R.id.text_city) as TextView

    }
}
