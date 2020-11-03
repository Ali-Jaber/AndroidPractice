package com.android.practice.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LinerLayout: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout)
        initToolbar()
        title = "Linear Layout"
    }
}