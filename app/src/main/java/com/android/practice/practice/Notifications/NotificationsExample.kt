package com.android.practice.practice.Notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_notifications_example.*

class NotificationsExample : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications_example)
        initToolbar()
        title = "Notifications"
        notification.setOnClickListener {
            displayNotifications()
        }

    }

    private fun displayNotifications() {
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
        builder.setSmallIcon(R.drawable.add_icon)
            .setContentTitle("Ali Jaber")
            .setContentText("Android Developer")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendIntent)
            .setStyle(NotificationCompat.BigTextStyle().bigText("Android Developer"))
            .addAction(R.drawable.ic_call, "Replay", pendIntent)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(10, builder.build())
    }

    companion object {
        const val CHANNEL_ID = "first_channelId"
    }
}