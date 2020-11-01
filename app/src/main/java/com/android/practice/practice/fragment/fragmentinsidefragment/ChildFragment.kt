package com.android.practice.practice.fragment.fragmentinsidefragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.android.practice.practice.R

class ChildFragment : Fragment(), View.OnClickListener {

    private var mActivityListener: OnChildFragmentToActivityInteractionListener? = null
    private var mParentListener: OnChildFragmentInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myViwe = inflater.inflate(R.layout.fragment_child, container, false)
        myViwe?.findViewById<Button>(R.id.child_fragment_contact_activity_button)?.setOnClickListener(this)
        myViwe?.findViewById<Button>(R.id.child_fragment_contact_parent_button)?.setOnClickListener(this)
        return myViwe
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnChildFragmentToActivityInteractionListener) {
            mActivityListener = context
        } else {
            throw RuntimeException("$context must implement OnChildFragmentToActivityInteractionListener")
        }

        if (parentFragment is OnChildFragmentInteractionListener) {
            mParentListener = parentFragment as OnChildFragmentInteractionListener
        } else {
            throw RuntimeException("$context must implement OnChildFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mActivityListener = null
        mParentListener = null
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.child_fragment_contact_activity_button ->
                mActivityListener?.messageFromChildFragmentToActivity("Hello, Activity. I am the child fragment.");
            R.id.child_fragment_contact_parent_button ->
                mParentListener?.messageFromChildToParent("Hello, parent. I am your child.");
        }
    }

    interface OnChildFragmentToActivityInteractionListener {
        fun messageFromChildFragmentToActivity(myString: String)
    }

    interface OnChildFragmentInteractionListener {
        fun messageFromChildToParent(myString: String);
    }
}