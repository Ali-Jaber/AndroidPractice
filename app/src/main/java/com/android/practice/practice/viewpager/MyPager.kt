package com.android.practice.practice.viewpager

import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import com.google.android.material.tabs.TabLayout

class MyPager : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_pager)
        initToolbar()
        val tabLayout = findViewById<TabLayout>(R.id.main_tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.main_pager)
        val adapter = PagerAdapter(supportFragmentManager).apply {
            this.addTab(MyTab("Food", CategoryFragment.newInstance(1, "Food")))
            this.addTab(MyTab("Drinks", CategoryFragment.newInstance(2, "Drinks")))
            this.addTab(MyTab("Deserts", CategoryFragment.newInstance(3, "Deserts")))
            this.addTab(MyTab("Other", CategoryFragment.newInstance(4, "Other")))
        }

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "Un-Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, "Reselected", Toast.LENGTH_SHORT).show()
            }

        })

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                Toast.makeText(applicationContext, "onPageScrolled", Toast.LENGTH_SHORT).show()
            }

            override fun onPageSelected(position: Int) {
                Toast.makeText(applicationContext, "onPageSelected", Toast.LENGTH_SHORT).show()
            }

            override fun onPageScrollStateChanged(state: Int) {
                Toast.makeText(applicationContext, "onPageScrollStateChanged", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.pager_toolbar))
        supportActionBar?.title = "View Pager"
    }
}