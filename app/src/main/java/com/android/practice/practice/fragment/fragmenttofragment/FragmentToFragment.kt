package com.android.practice.practice.fragment.fragmenttofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.android.practice.practice.R

class FragmentToFragment : AppCompatActivity() , Communicator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_to_fragment)
        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction().replace(R.id.relativeLayout, firstFragment)
            .commit()
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