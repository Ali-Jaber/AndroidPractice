package com.android.practice.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity2 : AppCompatActivity() {

    protected fun initToolbar() {
        setSupportActionBar(findViewById(R.id.toolbarXml))
    }
}