package com.android.practice.practice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class RadioButton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayoutRadio)

        val radioButton1 = RadioButton(this)
        radioButton1.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioButton1.id = 1.toInt()
        radioButton1.setText("Black")

        val radioButton2 = RadioButton(this)
        radioButton2.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioButton2.id = 2.toInt()
        radioButton2.setText("White")

        val radioButton3 = RadioButton(this)
        radioButton2.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioButton3.id = 3.toInt()
        radioButton3.setText("Blue")

        val radioGroup = findViewById<RadioGroup>(R.id.rg)
        if (radioGroup != null) {
            radioGroup.addView(radioButton1)
            radioGroup.addView(radioButton2)
            radioGroup.addView(radioButton3)

            radioGroup.setOnCheckedChangeListener { group, checkId ->
                var string = getString(R.string.you_selected)
                string += " " + getString(
                    if (checkId == 1) R.string.black
                    else if (checkId == 2) R.string.white
                    else R.string.blue
                )
                Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
            }
        }

    }
}