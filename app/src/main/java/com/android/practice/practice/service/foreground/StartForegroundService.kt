package com.android.practice.practice.service.foreground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import com.android.practice.practice.service.background.BackgroundService
import kotlinx.android.synthetic.main.activity_start_foreground_service.*
import kotlinx.android.synthetic.main.activity_start_service.*
import kotlinx.android.synthetic.main.activity_start_service.startBtn

class StartForegroundService : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_foreground_service)
        initToolbar()
        title = "Foreground Service"

        startBtnForeground.setOnClickListener {
            ContextCompat.startForegroundService(this, Intent(this, BackgroundService::class.java))
        }

        stopBtnForeground.setOnClickListener {
            stopService(Intent(this, BackgroundService::class.java))
        }
    }
}