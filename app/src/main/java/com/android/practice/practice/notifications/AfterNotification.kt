package com.android.practice.practice.notifications

import android.os.Bundle
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R

class AfterNotification : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_notification)
        initToolbar()
        title = "After Notification"
    }
}