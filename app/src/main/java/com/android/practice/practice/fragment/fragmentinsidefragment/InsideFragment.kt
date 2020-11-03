package com.android.practice.practice.fragment.fragmentinsidefragment

import android.os.Bundle
import android.util.Log
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R

class InsideFragment : BaseActivity(), ParentFragment.OnFragmentInteractionListener,
    ChildFragment.OnChildFragmentToActivityInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside)
        initToolbar()
        title = "Fragment Inside Fragment"
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.parent_fragment_container, ParentFragment())
        ft.commit()
    }

    override fun messageFromParentFragmentToActivity(myString: String) {
        Log.i("TAG", myString);
    }

    override fun messageFromChildFragmentToActivity(myString: String) {
        Log.i("TAG", myString);
    }
}