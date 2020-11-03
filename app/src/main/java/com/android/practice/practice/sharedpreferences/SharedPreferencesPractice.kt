package com.android.practice.practice.sharedpreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_shared_preferences_practice.*

class SharedPreferencesPractice : BaseActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var edit: SharedPreferences.Editor
    lateinit var et_username: EditText
    lateinit var et_email: EditText
    lateinit var et_birthDate: EditText
    lateinit var saveBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences_practice)
        initToolbar()
        title = "Shared Preferences Practice"
        et_username = findViewById(R.id.et_name)
        et_email = findViewById(R.id.et_email)
        et_birthDate = findViewById(R.id.et_birthDate)
        saveBtn = findViewById(R.id.btn_save_preferences)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        edit = sharedPreferences.edit()

        btn_save_preferences.setOnClickListener {
            saveData(
                et_username.text.toString(),
                et_email.text.toString(),
                et_birthDate.text.toString()
            )
        }

        btn_res.setOnClickListener {
            val username = sharedPreferences.getString(USERNAME_KEY, "Null")
            val email = sharedPreferences.getString(EMAIL_KEY, "Null")
            val birthDate = sharedPreferences.getString(BIRTHDATE_KEY, "Null")

            Toast.makeText(
                this,
                "Name: $username email: $email Birth Date: $birthDate",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData(
            et_username.text.toString(),
            et_email.text.toString(),
            et_birthDate.text.toString()
        )
    }

    private fun saveData(
        username: String,
        email: String,
        birthDate: String
    ) {
        edit.putString(USERNAME_KEY, username)
        edit.putString(EMAIL_KEY, email)
        edit.putString(BIRTHDATE_KEY, birthDate)
        edit.apply()
    }

    companion object {
        const val USERNAME_KEY = "username"
        const val EMAIL_KEY = "email"
        const val BIRTHDATE_KEY = "bithdate"
    }
}