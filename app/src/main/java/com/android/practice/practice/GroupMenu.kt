package com.android.practice.practice

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

lateinit var myTextView: TextView

class GroupMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_menu)
        myTextView = findViewById(R.id.tv)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.text_bold -> {
                myTextView.setTypeface(null, Typeface.BOLD)
                true
            }

            R.id.text_normal -> {
                myTextView.setTypeface(null, Typeface.NORMAL)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onColorGroupItemClick(item: MenuItem) {
        when (item.itemId) {
            R.id.red -> {
                item.isCheckable = true
                myTextView.setTextColor(Color.RED)
            }

            R.id.green -> {
                item.isCheckable = true
                myTextView.setTextColor(Color.GREEN)
            }

            R.id.blue -> {
                item.isCheckable = true
                myTextView.setTextColor(Color.BLUE)
            }
        }
    }

    fun onSizeGroupItemClick(item: MenuItem) {
        when (item.itemId) {
            R.id.large_text -> {
                item.isCheckable = true
                myTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,50F);
            }

            R.id.medium_text -> {
                item.isCheckable = true
                myTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30F);
            }

            R.id.small_text -> {
                item.isCheckable = true
                myTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F);
            }
        }
    }
}