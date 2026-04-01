package com.kotlinground.design.creationalpatterns.factory.notification

class EmailNotification: Notification {
    override fun send(message: String) {
        // email send logic)
    }
}
