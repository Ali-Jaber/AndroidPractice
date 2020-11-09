package com.android.practice.practice.broadcastreceiver

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.android.practice.practice.R

class ReceiverFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val TAG = "ReceiverFragment";

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_receiver, container, false)

        myView.findViewById<Button>(R.id.button1).setOnClickListener {
            val i = Intent(MyReciverActivity.ACTION1).also {
                it.setPackage("com.android.practice.practice")
            }
            activity?.sendBroadcast(i)
        }

        myView.findViewById<Button>(R.id.button2).setOnClickListener {
            val i = Intent(MyReciverActivity.ACTION2)
            context?.let { it1 -> LocalBroadcastManager.getInstance(it1).sendBroadcast(i) }
            activity?.sendBroadcast(i)
            Log.e(TAG, "Should have sent the broadcast.")
        }
        return myView
    }


}