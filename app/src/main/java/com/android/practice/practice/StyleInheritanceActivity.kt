package com.android.practice.practice

import android.os.Bundle

class StyleInheritanceActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_style_inheritance)
        initToolbar()
        title = "Style Inheritance"
    }
}