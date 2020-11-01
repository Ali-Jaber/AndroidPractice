package com.android.practice.practice.fragment.fragmenttofragment

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R

class FragmentToFragment : BaseActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_to_fragment)
        initToolbar()
        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction().replace(R.id.relativeLayout, firstFragment)
            .commit()
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.fragment_to_fragment_toolbar))
        supportActionBar?.title = "Fragment To Fragment"
    }

    override fun passData(data: String) {
        val bundle = Bundle()
        bundle.putString("inputText", data)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = SecondFrament()
        fragmentTwo.arguments = bundle
        transaction.replace(R.id.relativeLayout, fragmentTwo)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()

    }
}