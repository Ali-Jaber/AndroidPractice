package com.android.practice.practice.notifications

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.android.practice.practice.BaseActivity
import com.android.practice.practice.R
import kotlinx.android.synthetic.main.activity_mutiple_notifications_channel.*

class MultipleNotificationsChannel : BaseActivity() {

    private lateinit var notificationHelper: NotificationHelper
    private lateinit var notificationUi: NotificationUi

    companion object {
        private val TAG = MultipleNotificationsChannel::class.java.simpleName

        private const val NOTIFICATION_FOLLOW = 1
        private const val NOTIFICATION_UNFOLLOW = 2
        private const val NOTIFICATION_DM_FRIEND = 3
        private const val NOTIFICATION_DM_COWORKER = 4
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mutiple_notifications_channel)
        notificationHelper = NotificationHelper(this)
        initToolbar()
        title = "Multiple Notifications"
        notificationUi = NotificationUi()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun sendNotification(id: Int) {
        when (id) {
            NOTIFICATION_FOLLOW -> notificationHelper.notify(
                id, notificationHelper.getNotificationFollower(
                    getString(R.string.follower_title_notification),
                    getString(
                        R.string.follower_added_notification_body,
                        notificationHelper.randomName
                    )
                )
            )

            NOTIFICATION_UNFOLLOW -> notificationHelper.notify(
                id, notificationHelper.getNotificationFollower(
                    getString(R.string.follower_title_notification),
                    getString(
                        R.string.follower_removed_notification_body,
                        notificationHelper.randomName
                    )
                )
            )

            NOTIFICATION_DM_FRIEND -> notificationHelper.notify(
                id, notificationHelper.getNotificationDM(
                    getString(R.string.direct_message_title_notification),
                    getString(
                        R.string.dm_friend_notification_body,
                        notificationHelper.randomName
                    )
                )
            )

            NOTIFICATION_DM_COWORKER -> notificationHelper.notify(
                id, notificationHelper.getNotificationDM(
                    getString(R.string.direct_message_title_notification),
                    getString(
                        R.string.dm_coworker_notification_body,
                        notificationHelper.randomName
                    )
                )
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun goToNotificationSettings() {
        val settingsIntent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).also {
            it.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
        }
        startActivity(settingsIntent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun goToNotificationChannelSettings(channel: String) {
        val intent = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS).also {
            it.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
            it.putExtra(Settings.EXTRA_CHANNEL_ID, channel)
        }
        startActivity(intent)
    }

    internal inner class NotificationUi : View.OnClickListener {

        init {
            follow_button.setOnClickListener(this)
            un_follow_button.setOnClickListener(this)
            follower_channel_settings_button.setOnClickListener(this)
            friend_dm_button.setOnClickListener(this)
            coworker_dm_button.setOnClickListener(this)
            dm_channel_settings_button.setOnClickListener(this)
            go_to_settings_button.setOnClickListener(this)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onClick(view: View) {
            when (view.id) {
                R.id.follow_button -> sendNotification(NOTIFICATION_FOLLOW)
                R.id.un_follow_button -> sendNotification(NOTIFICATION_UNFOLLOW)
                R.id.follower_channel_settings_button -> goToNotificationChannelSettings(
                    NotificationHelper.FOLLOWERS_CHANNEL
                )
                R.id.friend_dm_button -> sendNotification(NOTIFICATION_DM_FRIEND)
                R.id.coworker_dm_button -> sendNotification(NOTIFICATION_DM_COWORKER)
                R.id.dm_channel_settings_button -> goToNotificationChannelSettings(
                    NotificationHelper.DIRECT_MESSAGE_CHANNEL
                )
                R.id.go_to_settings_button -> goToNotificationSettings()
                else -> Log.e(TAG, getString(R.string.error_click))
            }
        }
    }
}