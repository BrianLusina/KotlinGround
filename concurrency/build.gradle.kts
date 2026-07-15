plugins {
    kotlin("plugin.serialization") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.Jetbrains.Coroutines.core)
    testImplementation(Dependencies.Jetbrains.Coroutines.test)
}
