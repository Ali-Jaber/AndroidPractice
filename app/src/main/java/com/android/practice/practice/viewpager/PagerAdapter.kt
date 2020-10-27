package com.android.practice.practice.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    val tabs = ArrayList<MyTab>()

    fun addTab(tab: MyTab) = tabs.add(tab)

    override fun getCount(): Int =
        tabs.size


    override fun getItem(position: Int): Fragment =
        tabs[position].fragment

    override fun getPageTitle(position: Int): CharSequence? =
        tabs[position].name

}