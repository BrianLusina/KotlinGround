buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.KOTLIN_GRADLE)
    }
}

plugins {
    common
}

version = Versions.PROJECT
