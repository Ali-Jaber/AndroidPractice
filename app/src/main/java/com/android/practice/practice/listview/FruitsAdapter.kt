package com.android.practice.practice.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.android.practice.practice.R

class FruitsAdapter(private val context: Context) :
    BaseAdapter() {

    private val fruits = ArrayList<Fruits>()
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return fruits.size
    }

    override fun getItem(position: Int): Any {
        return fruits[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val fruitView: View
        val holder: ViewHolder
        if (convertView == null) {
            fruitView = inflater.inflate(R.layout.list_view, parent, false)
            holder = ViewHolder()
            holder.fruitName = fruitView.findViewById(R.id.txt_fruit)
            holder.fruitDesc = fruitView.findViewById(R.id.txt_desc)
            holder.fruitImage = fruitView.findViewById(R.id.fruit_image_view)
            fruitView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            fruitView = convertView
        }

        val fruit = fruits[position]
        val resourceId =
            context.resources.getIdentifier(fruit.image.toString(), "drawable", context.packageName)
        holder.fruitName?.text = fruit.name
        holder.fruitDesc?.text = fruit.desc
        holder.fruitImage?.setImageResource(resourceId)

        return fruitView
    }

    fun clear() {
        fruits.clear()
    }

    fun addAll(fruitsAdd: List<Fruits>) {
        fruits.addAll(fruitsAdd)
    }

    private class ViewHolder {
        var fruitName: TextView? = null
        var fruitDesc: TextView? = null
        var fruitImage: ImageView? = null
    }
}