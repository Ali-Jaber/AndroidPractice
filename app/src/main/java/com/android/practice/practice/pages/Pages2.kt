package com.android.practice.practice.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class Pages2 : BaseActivity() {
        private lateinit var toolbar: Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private var tabChat: TabItem? = null
    private var tabStatus: TabItem? = null
    private var tabCall: TabItem? = null
    private lateinit var pageAdapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pages2)
        toolbar = findViewById(R.id.page_toolbar)
        initToolbar()

        tabLayout = findViewById(R.id.page_tabLayout)
        tabCall = findViewById(R.id.tabCall)
        tabChat = findViewById(R.id.tabChat)
        tabStatus = findViewById(R.id.tabStatus)
        viewPager = findViewById(R.id.viewPager)
        pageAdapter = PageAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = pageAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    1 -> {
                        changeToolbar(R.color.greenDark)
                        changeTabLayout(R.color.greenDark)
                        changeStatusBarColor(R.color.greenDark)
                    }
                    2 -> {
                        changeToolbar(android.R.color.darker_gray)
                        changeTabLayout(android.R.color.darker_gray)
                        changeStatusBarColor(android.R.color.darker_gray)
                    }
                    else -> {
                        changeToolbar(R.color.yellow)
                        changeTabLayout(R.color.yellow)
                        changeStatusBarColor(R.color.orange)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@Pages2, "onTabUnselected", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@Pages2, "onTabReselected", Toast.LENGTH_SHORT).show()
            }

            private fun changeTabLayout(color: Int) {
                tabLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        this@Pages2,
                        color
                    )
                )
            }

            private fun changeToolbar(color: Int) {
                toolbar.setBackgroundColor(
                    ContextCompat.getColor(
                        this@Pages2,
                        color
                    )
                )
            }

            private fun changeStatusBarColor(color: Int) {
                window.statusBarColor = ContextCompat.getColor(
                    this@Pages2,
                    color
                )
            }
        })
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.page_toolbar))
        supportActionBar?.title = "TabLayout"
    }
}