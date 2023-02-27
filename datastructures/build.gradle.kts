plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.Jetbrains.kotlinXDatetime)
    implementation(Dependencies.Jetbrains.kotlinXCollectionsImmutable)
    implementation(Dependencies.Jetbrains.kotlinXSerializationJson)
    implementation(Dependencies.Jetbrains.kotlinXCoroutinesCore)
    implementation(Dependencies.Jetbrains.kotlinXCoroutinesTest)
}
