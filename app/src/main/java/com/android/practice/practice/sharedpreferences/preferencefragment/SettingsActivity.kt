package com.android.practice.practice.sharedpreferences.preferencefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.practice.practice.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        supportFragmentManager.beginTransaction()
            .replace(R.id.content, SettingsFragment())
            .commit()
    }
}