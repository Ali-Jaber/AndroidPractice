package com.android.practice.practice.fragment.fragmentinsidefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.practice.practice.R

class InsideFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside)
    }
}