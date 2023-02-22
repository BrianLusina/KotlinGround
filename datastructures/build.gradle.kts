plugins {
    kotlin("jvm")
    kotlin("plugin.allopen")
    kotlin("plugin.serialization") version "1.6.10"
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
    implementation(Dependencies.Utils.Jetbrains.kotlinXCollectionsImmutable)
    implementation(Dependencies.Utils.Jetbrains.kotlinXSerializationJson)
}
