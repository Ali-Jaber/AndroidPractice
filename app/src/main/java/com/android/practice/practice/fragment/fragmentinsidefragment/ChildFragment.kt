package com.android.practice.practice.fragment.fragmentinsidefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.practice.practice.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ChildFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var mActivityListener: OnChildFragmentToActivityInteractionListener? = null
    private var mParentListener: OnChildFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChildFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
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