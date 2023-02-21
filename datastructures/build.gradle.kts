plugins {
    kotlin("jvm")
    kotlin("plugin.allopen")
    idea
}

repositories {
    mavenCentral()
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(Dependencies.Utils.Jetbrains.kotlinXDatetime)
}
