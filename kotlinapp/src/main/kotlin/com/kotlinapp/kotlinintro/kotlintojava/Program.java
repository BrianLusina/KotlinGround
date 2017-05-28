package com.kotlinapp.kotlinintro.kotlintojava;

/**
 * @author lusinabrian on 28/05/17.
 */
public class Program {

    public static void main(String[] args) {
        // creats a class defined in Kotlin
        Meeting meeting = new Meeting("Board Meeting");

        meeting.setLocation("Nairobi");

        System.out.println("The meeting is in " + meeting.getLocation());

        meeting.description = "Discuss why Kotlin will overthrow Java";

        // these are exposed here as static due to the annotations @JvmField and @JvmStatic
        int appVersionField = Meeting.APP_VERSION;
        int appVersion = Meeting.getAppVersion();

        // however for this, you will have to access the companion object first before
        // accessing the field or method
        // these are obviously not clean ways to access field and methods from Kotlin
        String appNameField = Meeting.Companion.getAPP_NAME();
        String appName = Meeting.Companion.getAppName();
    }
}
