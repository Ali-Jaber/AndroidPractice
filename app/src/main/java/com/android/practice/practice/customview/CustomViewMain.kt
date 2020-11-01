package com.android.practice.practice.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_custom_view_main.*

class CustomViewMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view_main)
        val list: MutableList<String> = ArrayList()
        list.add("Kotlin")
        list.add("Java")
        list.add("C++")
        list.add("Html")
        list.add("C#")
        list.add("Php")
        list.add("JavaScript")

        customview.setData(list)
        customview.setTitle("Languages")
        submit.setOnClickListener {
            Toast.makeText(this,"Selected Data : ${customview.getSelectedData()}",Toast.LENGTH_SHORT).show()
        }
    }
}