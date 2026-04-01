package com.kotlinground.design.creationalpatterns.factory.notification

class NotificationFactory {
    companion object {
        @JvmStatic
        fun create(type: String): Notification? {
            return when (type) {
                "email" -> EmailNotification()
                "sms" -> SmsNotification()
                else -> null
            }
        }
    }
}
