package com.android.practice.practice.fragment.fragmentinsidefragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.android.practice.practice.R

class ParentFragment : Fragment(), View.OnClickListener,
    ChildFragment.OnChildFragmentInteractionListener {

    private var mListener: OnFragmentInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_parent, container, false)
        myView.findViewById<Button>(R.id.parent_fragment_button).setOnClickListener {
            this
        }
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val childFragment = ChildFragment()
        childFragmentManager.beginTransaction()
            .addToBackStack("child")
            .add(R.id.fragment_container_child, childFragment).commit();
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener");
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onClick(v: View?) {
        mListener?.messageFromParentFragmentToActivity("I am the parent fragment!")
    }

    override fun messageFromChildToParent(myString: String) {
        Log.i("TAG", myString);
    }

    interface OnFragmentInteractionListener {
        fun messageFromParentFragmentToActivity(myString: String);
    }
}