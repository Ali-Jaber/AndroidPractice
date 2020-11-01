package com.android.practice.practice.sharedpreferences

import android.os.Bundle
import android.widget.Toast
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_shared_preferences_two.*

class SharedPreferencesTwo : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_two)
        initToolbar()
        val sharedPreferences = getSharedPreferences("emails", MODE_PRIVATE)


        btn_second_restore.setOnClickListener {
            val email = sharedPreferences.getString("email", "No Email Available")
            Toast.makeText(this@SharedPreferencesTwo, email, Toast.LENGTH_SHORT).show()
        }
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.shared_preferences_two))
        supportActionBar?.title = "Shared Preferences Activity 2"
    }
}