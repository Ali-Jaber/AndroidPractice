package com.android.practice.practice.fragment.fragmenttofragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_one.view.*
import kotlin.math.log


class FirstFragment : Fragment() {
    private lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_one, container, false) as ViewGroup

        val toolbar = rootView.findViewById<Toolbar>(R.id.fragment_toolbar)

        toolbar.inflateMenu(R.menu.fragment1_toolbar)
//        inflater.inflate(R.menu.toolbar_options_menu, menu)
        toolbar.title = "First Fragment"
//        toolbar.setOnMenuItemClickListener {
//            if (it.itemId == R.id.settings) {
//                Toast.makeText(requireActivity(), "First Fragment", Toast.LENGTH_LONG).show()
//            }
//            true
//        }
        communicator = activity as Communicator
        rootView.btnSend.setOnClickListener {
            communicator.passData(rootView.editText.text.toString())
        }
        return rootView
    }
}