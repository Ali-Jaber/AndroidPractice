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
    private val myFruits = arrayOf(
        "Apple", "Apricot", "Acai Berries", "Citrus", "Banana",
        "Grapes", "Melons", "Berries", "Pomegranate", "Pineapple"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

//        var myAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myFruits)
//        myListView.adapter = myAdapter

        val fruitsList = ArrayList<Fruits>()

        fruitsList.add(Fruits("Apple", "desc 01", R.drawable.apple))
        fruitsList.add(Fruits("Apricot", "desc 02", R.drawable.apricots))
        fruitsList.add(Fruits("Citrus", "desc 03", R.drawable.citrus))
        fruitsList.add(Fruits("Banana", "desc 04", R.drawable.banana))
        fruitsList.add(Fruits("Grapes", "desc 05", R.drawable.grapes))
        fruitsList.add(Fruits("Melons", "desc 06", R.drawable.melons))
        fruitsList.add(Fruits("Berries", "desc 07", R.drawable.berries))
        fruitsList.add(Fruits("Pomegranate", "desc 08", R.drawable.pomegranate))
        fruitsList.add(Fruits("Pineapple", "desc 09", R.drawable.pineapple))

        var myAdapter = FruitsAdapter(this, fruitsList)
        myListView.adapter = myAdapter
        myListView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val txt = view as TextView
                Toast.makeText(this, txt.text.toString(), Toast.LENGTH_SHORT).show()
            }


    }
}