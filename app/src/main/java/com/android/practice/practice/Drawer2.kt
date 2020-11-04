package com.android.practice.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.android.practice.practice.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_drawer.*

class Drawer2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toggleButton: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        toggleButton = ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close)
        toggleButton.isDrawerIndicatorEnabled = true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_public -> {
                Toast.makeText(this, "Publication", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_store -> {
                Toast.makeText(this, "Android Store", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_news -> {
                Toast.makeText(this, "Newsletter", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_join -> {
                Toast.makeText(this, "Join Community", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_contact -> {
                Toast.makeText(this, "Contact us", Toast.LENGTH_SHORT).show()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}