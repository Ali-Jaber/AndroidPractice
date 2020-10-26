package com.android.practice.practice.fragment.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.android.practice.practice.R

class FragmentToolBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(android.R.id.content, FragmentWay())
                .commit()
        }
    }
}

class FragmentWay : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_fragment_tool_bar, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.fragment_toolbar)

        toolbar.inflateMenu(R.menu.toolbar)
        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.settings) {
                Toast.makeText(requireActivity(), "Awesome", Toast.LENGTH_LONG).show()
            }
            true
        }
        return view
    }
}