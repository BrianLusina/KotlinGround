plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":utils"))
    implementation(Dependencies.Jetbrains.kotlinXDatetime)
    implementation(Dependencies.Jetbrains.kotlinXCollectionsImmutable)
    implementation(Dependencies.Jetbrains.kotlinXSerializationJson)
    implementation(Dependencies.Jetbrains.Coroutines.core)
    testImplementation(Dependencies.Jetbrains.Coroutines.test)
}
