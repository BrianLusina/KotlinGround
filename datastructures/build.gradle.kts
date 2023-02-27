plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.6.10"
    idea
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.Utils.Jetbrains.kotlinXDatetime)
    implementation(Dependencies.Utils.Jetbrains.kotlinXCollectionsImmutable)
    implementation(Dependencies.Utils.Jetbrains.kotlinXSerializationJson)
    implementation(Dependencies.Utils.Jetbrains.kotlinXCoroutinesCore)
    implementation(Dependencies.Utils.Jetbrains.kotlinXCoroutinesTest)
}
