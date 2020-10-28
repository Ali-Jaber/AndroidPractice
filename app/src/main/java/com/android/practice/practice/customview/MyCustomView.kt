package com.android.practice.practice.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_my_custom_view.*

class MyCustomView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_custom_view)
        happyButton.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.HAPPY
        }

        sadButton.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.SAD
        }
    }
}