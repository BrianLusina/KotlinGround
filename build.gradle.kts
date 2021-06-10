import java.net.URI

buildscript {
    repositories {
        jcenter()
//        maven { url = URI.create("https://plugins.gradle.org/m2/") }
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.KOTLIN_GRADLE)
        classpath("com.android.tools.build:gradle:2.3.0")
    }
}

plugins {
    common
}

version = Versions.PROJECT
