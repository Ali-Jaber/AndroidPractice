package com.android.practice.practice.service.foreground

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.android.practice.practice.R
import com.android.practice.practice.notifications.NotificationsExample

class ForegroundService : Service() {

    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.sound)
        mediaPlayer.setOnCompletionListener {
            stopSelf()
        }
        Log.d("my service", "service created")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(1,getNotifications())
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("my service", "service destroy")
        if(mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun getNotifications(): Notification? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                CHANNEL_ID,
                "CHANNEL display name",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            notificationChannel.description = "my channel description"
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(notificationChannel)
        }
        val intent = Intent(this, NotificationsExample::class.java)
        val pendIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
        
        return builder.setSmallIcon(R.drawable.add_icon)
            .setContentTitle("Ali Jaber")
            .setContentText("Android Developer")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendIntent)
            .setStyle(NotificationCompat.BigTextStyle().bigText("Android Developer"))
            .build()

//        val notificationManager = NotificationManagerCompat.from(this)
//        notificationManager.notify(10, builder.build())
    }

    companion object {
        const val CHANNEL_ID = "first_channelId"
    }
}