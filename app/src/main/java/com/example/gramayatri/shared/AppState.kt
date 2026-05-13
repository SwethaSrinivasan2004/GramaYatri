package com.example.gramayatri.shared

import androidx.compose.runtime.mutableStateListOf
import java.text.SimpleDateFormat
import java.util.*

data class ActivityItem(
    val user: String,
    val message: String,
    val time: String,
    val type: ActivityType
)

enum class ActivityType {
    PASS, BOARD, DELAY, CANCEL, CUSTOM
}

object AppState {

    // 👤 Temporary logged-in user (replace later with real auth)
    var currentUser: String = "You"

    // 📊 Activity feed
    val activities = mutableStateListOf<ActivityItem>()

    // 🔔 Alerts (subset of activities)
    val alerts = mutableStateListOf<ActivityItem>()

    // 🔔 One-time banner message
    var latestNotification: String? = null

    fun getCurrentTime(): String {
        return SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
    }

    fun addActivity(message: String, type: ActivityType) {
        val item = ActivityItem(
            user = currentUser,
            message = message,
            time = getCurrentTime(),
            type = type
        )

        // newest on top
        activities.add(0, item)

        // 📌 Only important events trigger "alerts"
        if (type == ActivityType.CANCEL || type == ActivityType.DELAY) {
            alerts.add(0, item)
            latestNotification = message
        }
    }
}