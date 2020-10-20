package com.android.practice.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MenuBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.message -> {
                Toast.makeText(applicationContext, "Shows message icon", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.picture -> {
                Toast.makeText(applicationContext, "Shows picture icon", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.mode -> {
                Toast.makeText(applicationContext, "Shows call icon", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.about -> {
                Toast.makeText(applicationContext, "Shows calculator icon", Toast.LENGTH_SHORT)
                    .show()
                return true
            }

            R.id.exit -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}