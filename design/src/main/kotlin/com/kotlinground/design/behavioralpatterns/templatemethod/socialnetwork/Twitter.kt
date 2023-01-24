package com.kotlinground.design.behavioralpatterns.templatemethod.socialnetwork

class Twitter(override var username: String, override var password: String) : Network() {
    override fun login(username: String, password: String): Boolean {
        println("\nChecking user's parameters")
        println("Name: $username")
        print("Password: ")
        for (i in password.indices) {
            print("*")
        }
        simulateNetworkLatency()
        println("\n\nLogIn success on Twitter")
        return true
    }

    override fun sendData(data: ByteArray): Boolean {
        val messagePosted = true
        return if (messagePosted) {
            println("Message: '$data' was posted on Twitter")
            true
        } else {
            false
        }
    }

    override fun logout() {
        println("User: $username was logged out from Twitter")
    }

    private fun simulateNetworkLatency() {
        try {
            var i = 0
            println()
            while (i < 10) {
                print(".")
                Thread.sleep(500)
                i++
            }
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }
}
