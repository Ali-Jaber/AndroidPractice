package com.android.practice.practice.service.jobservice

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.os.Bundle
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_my_job.*

class MyJobActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_job)
        initToolbar()
        title = "Job Service"

        btnStartJob.setOnClickListener {
            val componentName = ComponentName(baseContext, MyJobService::class.java)
            val infoBuilder: JobInfo.Builder = JobInfo.Builder(10, componentName)
                .setMinimumLatency(5000)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)

            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) {
                infoBuilder.setPeriodic(5000)

            } else {
                infoBuilder.setMinimumLatency(5000)
            }
            val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
            jobScheduler.schedule(infoBuilder.build())
        }
    }
}