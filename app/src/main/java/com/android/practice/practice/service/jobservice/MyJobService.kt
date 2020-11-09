package com.android.practice.practice.service.jobservice

import android.app.Service
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.android.practice.practice.R

class MyJobService : JobService() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onStartJob(jobParameters: JobParameters?): Boolean {
        mediaPlayer = MediaPlayer.create(this, R.raw.sound).also {
            it.start()
            it.setOnCompletionListener {
                jobFinished(jobParameters, false)
            }
        }
        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show()
        Log.d("MyJobService", "started")
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
        Log.d("MyJobService", "Stopped")
        if (mediaPlayer != null && mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        return false
    }
}