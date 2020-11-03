package com.android.practice.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CoordinatorLayout : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordinate_layout)
        initToolbar()
        title = "Coordinator Layout"
    }
}