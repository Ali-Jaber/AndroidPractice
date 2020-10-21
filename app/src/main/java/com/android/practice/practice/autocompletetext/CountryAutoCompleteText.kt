package com.android.practice.practice.autocompletetext

import android.os.Bundle
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.android.practice.practice.R

class CountryAutoCompleteText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auto_complete_text)
        val edit = findViewById<AutoCompleteTextView>(R.id.actv)
        val country = fillCountryList()
        val adapter = AutoCompleteCountryAdapter(this)
        adapter.addAll(country)
        edit.setAdapter(adapter)

    }

    private fun fillCountryList(): List<CountryItem> {
        return listOf(
            CountryItem("Afghanistan", R.drawable.afghanistan),
            CountryItem("Albania", R.drawable.albania),
            CountryItem("Algeria", R.drawable.algeria),
            CountryItem("Andorra", R.drawable.andorra),
            CountryItem("Angola", R.drawable.angola),
        )
    }
}