package com.android.practice.practice.Notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R

class AfterNotification : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_notification)
        initToolbar()
    }

    override fun initToolbar() {
        setSupportActionBar(findViewById(R.id.after_notification))
        supportActionBar?.title = "After Notification"
    }
}