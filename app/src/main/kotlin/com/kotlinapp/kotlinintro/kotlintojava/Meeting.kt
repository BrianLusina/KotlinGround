package com.kotlinapp.kotlinintro.kotlintojava

/**
 * @author lusinabrian on 28/05/17.
 * title field will be final and will only be set when the meeting class is initialized
 * the title field can be be set again with a setter method, this is because the title field
 * is a readonly attribute. This will create getter method for title instead
 */
class Meeting(val title: String) {
    // this will create setter and getter methods
    var location = ""

    // this exposes the description field in Java as public
    @JvmField
    var description = ""

    /**
     * We expect this to throw an error if the attendee is null or empty
     * This annotation tells Java compiler that this method may throw this MeetingException
     * Which means that Java compiler MUST handle this method with a try catch block
     * */
    @Throws(MeetingException::class)
    fun addAttendee(attendee: String) {
        if (attendee.isNullOrEmpty()) {
            throw MeetingException("Attendee must have a name")
        }
    }

    // this exposes fields and methods to JAVA as static, since Kotlin has no concept of static
    companion object {
        @JvmField
        val APP_VERSION = 1
        val APP_NAME = "Meeting Conundrum"

        @JvmStatic
        fun getAppVersion(): Int {
            return APP_VERSION
        }

        fun getAppName(): String {
            return APP_NAME
        }
    }
}

class MeetingException(message: String) : Exception(message)