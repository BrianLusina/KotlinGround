buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath(Plugins.KOTLIN_GRADLE)
        classpath(Plugins.JACOCO_PLUGIN)
        // TODO: dokka gradle plugin is failing to resolve
//        classpath(Plugins.DOKKA_GRADLE)
    }
}

plugins {
    common
}

version = Versions.PROJECT
