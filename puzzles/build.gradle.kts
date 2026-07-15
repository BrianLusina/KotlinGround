plugins {
    kotlin("plugin.serialization") version "1.6.10"
}

dependencies {
    implementation(project(":datastructures"))
}

repositories {
    mavenCentral()
}