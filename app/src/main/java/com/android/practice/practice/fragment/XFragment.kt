package com.android.practice.practice.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.android.practice.practice.R

class XFragment : Fragment(), SuperFragment {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_x, container, false)
    }
}