package com.android.practice.practice.service.background

import android.content.Intent
import android.os.Bundle
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_start_service.*

class StartServiceActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_service)
        initToolbar()
        title = "Background Service"

        startBtn.setOnClickListener {
            startService(Intent(this, BackgroundService::class.java))
        }

        stopBtn.setOnClickListener {
            stopService(Intent(this, BackgroundService::class.java))
        }
    }
}