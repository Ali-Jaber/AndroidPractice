package com.android.practice.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ScrollHorizontal : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scroll_view_horizontal)
        initToolbar()
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.scroll_horizontal_toolbar))
        supportActionBar?.title = "Scroll Horizontal"
    }
}