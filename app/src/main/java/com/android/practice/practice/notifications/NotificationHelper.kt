package com.android.practice.practice.notifications

import android.app.*
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import com.android.practice.practice.R

import java.util.Random


@RequiresApi(Build.VERSION_CODES.O)
class NotificationHelper(context: Context) : ContextWrapper(context) {
    val icon: Bitmap = BitmapFactory.decodeResource(resources, android.R.drawable.stat_notify_chat)

    private val notificationManager: NotificationManager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    val randomName: String
        get() {
            val names = applicationContext.resources.getStringArray(R.array.names_array)
            return names[Random().nextInt(names.size)]
        }

    private val pendingIntent: PendingIntent
        get() {
            val openMainIntent = Intent(this, MultipleNotificationsChannel::class.java)
            val stackBuilder = TaskStackBuilder.create(this)
            stackBuilder.addParentStack(MultipleNotificationsChannel::class.java)
            stackBuilder.addNextIntent(openMainIntent)
            return stackBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT)
        }

    companion object {
        const val FOLLOWERS_CHANNEL = "follower"
        const val DIRECT_MESSAGE_CHANNEL = "direct_message"
    }

    init {
        val followersChannel = NotificationChannel(
            FOLLOWERS_CHANNEL, "Follower Notification Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        ).also {
            it.lightColor = Color.GREEN
            it.setShowBadge(false)
        }

        notificationManager.createNotificationChannel(followersChannel)

        val dmChannel = NotificationChannel(
            DIRECT_MESSAGE_CHANNEL,
            "Direct Messages Channel",
            NotificationManager.IMPORTANCE_HIGH
        ).also {
            it.lightColor = Color.BLUE
            it.setShowBadge(true)
        }
        notificationManager.createNotificationChannel(dmChannel)
    }

    fun notify(id: Int, notification: Notification.Builder) {
        notificationManager.notify(id, notification.build())
    }

    fun getNotificationFollower(title: String, body: String) = Notification.Builder(
        applicationContext,
        FOLLOWERS_CHANNEL
    )
        .setContentTitle(title)
        .setContentText(body)
        .setSmallIcon(android.R.drawable.stat_notify_chat)
        .setLargeIcon(icon)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)

    fun getNotificationDM(title: String, body: String) = Notification.Builder(
        applicationContext,
        DIRECT_MESSAGE_CHANNEL
    )
        .setContentTitle(title)
        .setContentText(body)
        .setSmallIcon(android.R.drawable.stat_notify_chat)
        .setAutoCancel(true)
        .setContentIntent(pendingIntent)
}