package com.android.practice.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LinerLayout: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout)
        initToolbar()
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.linear_toolbar))
        supportActionBar?.title = "Linear Layout"
    }
}