package com.android.practice.practice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.coordinate_layout.*

class CoordinateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val countries = resources.getStringArray(R.array.countries)
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,countries)
        autoCompleteTextView.setAdapter(arrayAdapter)
        fba.setOnClickListener {
            Snackbar.make(rootLayout, "Floating Action Button", Snackbar.LENGTH_LONG).show()
        }

        checkedTextView.isChecked = false
        checkedTextView.setCheckMarkDrawable(android.R.drawable.
        checkbox_off_background)

        checkedTextView.setOnClickListener {
            checkedTextView.isChecked = !checkedTextView.isChecked
            checkedTextView.setCheckMarkDrawable(if (checkedTextView.isChecked)
                android.R.drawable.checkbox_on_background
            else android.R.drawable.checkbox_off_background)

            val message = getString(R.string.pre_msg) + " " +
                    if (checkedTextView.isChecked)
                        getString(R.string.checked)
                    else getString(R.string.unchecked)
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }

}