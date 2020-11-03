package com.android.practice.practice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected fun initToolbar() {
        setSupportActionBar(findViewById(R.id.toolbarXml))
    }
}