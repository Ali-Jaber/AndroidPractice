package com.android.practice.practice.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.list_view.view.*

class FruitsAdapter(context: Context, fruits: ArrayList<Fruits>) :
    ArrayAdapter<Fruits>(context, 0, fruits) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listItemView = LayoutInflater.from(context).inflate(R.layout.list_view, parent, false)
        val fruits = getItem(position)
        val name = fruits?.name
        val desc = fruits?.desc
        val image = fruits?.image

        listItemView.txt_fruit.text = name
        listItemView.txt_desc.text = desc
        listItemView.fruit_image_view.setImageResource(image!!)
        return listItemView
    }
}