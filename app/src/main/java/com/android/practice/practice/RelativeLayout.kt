package com.android.practice.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RelativeLayout : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.relative_layout)
        initToolbar()
        title = "Relative Layout"
    }
}