package com.android.practice.practice.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_shared_preferences_one.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class SharedPreferencesOne : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_one)
        initToolbar()
        val sharedPreferences = getSharedPreferences("emails", MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        btn_save.setOnClickListener {
            edit.putString("email", "c.ali2009@hotmail.com")
            edit.apply()
        }

        btn_restore.setOnClickListener {
//            val email = sharedPreferences.getString("email", "No Email Available")
//            Toast.makeText(this@SharedPreferencesOne, email, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SharedPreferencesTwo::class.java))
        }
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.shared_preferences_one))
        supportActionBar?.title = "Shared Preferences Activity 1"
    }
}