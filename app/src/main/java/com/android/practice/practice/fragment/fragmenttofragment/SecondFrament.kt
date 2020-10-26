package com.android.practice.practice.fragment.fragmenttofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.fragment_two.view.*

private const val ARG_PARAM1 = "inputText"
class SecondFrament : Fragment() {

    var inputText: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_two, container, false)
        val toolbar = rootView.findViewById<Toolbar>(R.id.fragment_toolbar)

        toolbar.inflateMenu(R.menu.toolbar)
        toolbar.title = "Second Fragment"
        toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.settings) {
                Toast.makeText(requireActivity(), "Second Fragment", Toast.LENGTH_LONG).show()
            }
            true
        }

        inputText = arguments?.getString(ARG_PARAM1)
        rootView.outPutTextView.text = inputText
        return rootView
    }
}