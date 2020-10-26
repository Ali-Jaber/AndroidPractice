package com.android.practice.practice.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.android.practice.practice.R

class MainFragment : AppCompatActivity() {
    private val fm = supportFragmentManager
    private val ft = fm.beginTransaction()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        val btnX = findViewById<Button>(R.id.main_btn_x)
        val btnY = findViewById<Button>(R.id.main_btn_y)

        btnX.setOnClickListener {
            View.OnClickListener {
                val xFragment = XFragment()
                setupFragment()
            }
        }

        btnY.setOnClickListener {
            View.OnClickListener {
                val yFragment = YFragment()
                setupFragment()
            }
        }
    }

    private fun setupFragment() {
        val xFragment = XFragment()
        ft.replace(R.id.fragment_container, xFragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}