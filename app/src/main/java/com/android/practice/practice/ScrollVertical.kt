package com.android.practice.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ScrollVertical : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scroll_view_vertical)
        initToolbar()
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.scroll_view_toolbar))
        supportActionBar?.title = "Scroll View"
    }
}