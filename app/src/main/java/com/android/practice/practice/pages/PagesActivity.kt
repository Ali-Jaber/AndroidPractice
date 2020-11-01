package com.android.practice.practice.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import com.android.practice.practice.viewpager.MyTab
import com.android.practice.practice.viewpager.PagerAdapter
import kotlinx.android.synthetic.main.activity_pages.*

class PagesActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pages)
        initToolbar()
        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addTab(MyTab("F1", F1()))
        adapter.addTab(MyTab("F2", F2()))
        viewPage.adapter = adapter
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        title = "Pages"
    }

}

class F1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        val textView = TextView(context)
        textView.textSize = 16F
        textView.text = "F1"
        return textView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.fragment1_toolbar, menu)
    }
}

class F2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        val textView = TextView(context)
        textView.textSize = 16F
        textView.text = "F2"
        return textView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.fragment2_toolbar, menu)
    }

}