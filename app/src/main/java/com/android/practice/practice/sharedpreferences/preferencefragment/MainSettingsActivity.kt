package com.android.practice.practice.sharedpreferences.preferencefragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_main_settings.*

class MainSettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_settings)

        setSupportActionBar(findViewById(R.id.app_toolbar))
    }

    override fun onResume() {
        super.onResume()
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        et_allow_notification.setText(
            sharedPref.getBoolean(
                getString(R.string.pref_key_allow_notification),
                false
            ).toString()
        )
        et_zipcode.setText(sharedPref.getString(getString(R.string.pref_key_zipcode), ""))
        et_unit.setText(sharedPref.getString(getString(R.string.pref_key_unit), ""))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_setting, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}