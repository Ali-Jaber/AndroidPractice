package com.android.practice.practice.spinner

import android.os.Bundle
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.spinner_main.*

class SpinnerMain : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spinner_main)
        initToolbar()
//        intiToolbar("Spinner")
//        supportActionBar.getThemedContext.colo
        val androidIcons = listOf(
            Model("Cupcake", "cupcake"),
            Model("Donut", "donut"),
            Model("Eclairs", "eclairs"),
            Model("Froyo", "froyo"),
            Model("Gingerbread", "gingerbread"),
            Model("Honeycomb", "honeycomb"),
            Model("Icecream", "icecream"),
            Model("Jellybean", "jellybean"),
            Model("Kitkat", "kitkat"),
            Model("Lolipop", "lolipop"),
            Model("Marshmallow", "marshmallow"),
            Model("Nougat", "nougat"),
            Model("Oreo", "oreo"),
            Model("Pie", "pie"),
        )

        val customDropDownAdapter = CustomDropDownAdapter(this)
        customDropDownAdapter.addAll(androidIcons)
        spinner04.adapter = customDropDownAdapter
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.spinner_toolbar))
        supportActionBar?.title = "Spinner"
//        supportActionBar?.show()
    }

//    override fun intiToolbar(heading: String) {
////        supportActionBar?.title = "Spinner"
//        val actionBar = supportActionBar!!
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setDisplayShowHomeEnabled(false);
////        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.title_bar_gray)));
//        actionBar.title = heading;
//        actionBar.show();
//
//    }
}