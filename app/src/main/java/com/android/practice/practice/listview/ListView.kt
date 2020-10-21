package com.android.practice.practice.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_list_view.*

class ListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val fruitsList = listOf(
            Fruits("Apple", "desc 01", R.drawable.apple),
            Fruits("Apricot", "desc 02", R.drawable.apricots),
            Fruits("Citrus", "desc 03", R.drawable.citrus),
            Fruits("Banana", "desc 04", R.drawable.banana),
            Fruits("Grapes", "desc 05", R.drawable.grapes),
            Fruits("Melons", "desc 06", R.drawable.melons),
            Fruits("Berries", "desc 07", R.drawable.berries),
            Fruits("Pomegranate", "desc 08", R.drawable.pomegranate),
            Fruits("Pineapple", "desc 09", R.drawable.pineapple),
        )
        var myAdapter = FruitsAdapter(this)
        myAdapter.addAll(fruitsList)
        myListView.adapter = myAdapter
        myListView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val txt = view as TextView
                Toast.makeText(this, txt.text.toString(), Toast.LENGTH_SHORT).show()
            }


    }
}