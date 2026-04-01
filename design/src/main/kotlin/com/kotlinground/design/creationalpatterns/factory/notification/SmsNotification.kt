package com.kotlinground.design.creationalpatterns.factory.notification

class SmsNotification: Notification {
    override fun send(message: String) {
        // sms send logic
    }
}
