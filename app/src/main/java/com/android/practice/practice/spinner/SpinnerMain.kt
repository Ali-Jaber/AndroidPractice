package com.android.practice.practice.spinner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.spinner_main.*

class SpinnerMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spinner_main)

        val androidIcons = listOf(
            Model("Cupcake", "cupcake"),
            Model("Donut", "donut"),
            Model("Eclairs", "eclairs"),
            Model("Froyo", "froyo"),
            Model("Gingerbread", "gingerbread"),
            Model("Honeycomb", "honeycomb"),
            Model("Icecream", "icecream"),
            Model("Jellybean", "jellybean"),
            Model("Kitkat", "kitkat"),
            Model("Lolipop", "lolipop"),
            Model("Marshmallow", "marshmallow"),
            Model("Nougat", "nougat"),
            Model("Oreo", "oreo"),
            Model("Pie", "pie"),
        )

        val customDropDownAdapter = CustomDropDownAdapter(this)
        customDropDownAdapter.addAll(androidIcons)
        spinner04.adapter = customDropDownAdapter
    }
}