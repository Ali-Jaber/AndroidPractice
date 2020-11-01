package com.android.practice.practice.fragment.dialog

import android.os.Bundle
import android.widget.Toast
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_my_dialog_fragment.*

class MyDialogFragment : BaseActivity(), OnPositiveClickListener, OnNegativeClickListener,
    OnNeutralClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_dialog_fragment)
        initToolbar()
        btn_show.setOnClickListener {
            val fragment =
                DialogFragmentImpl.newInstance("Confirmation", "Are you sure", R.drawable.ic_info)
            fragment.show(supportFragmentManager, null)
        }
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.dialog_toolbar))
        supportActionBar?.title = "Dialog Fragment"
    }

    override fun onPositiveButtonClicked() {
        Toast.makeText(this, "Yes Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onNegativeButtonClicked() {
        Toast.makeText(this, "No Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onNeutralButtonClicked() {
        Toast.makeText(this, "Neutral Clicked", Toast.LENGTH_SHORT).show()
    }
}