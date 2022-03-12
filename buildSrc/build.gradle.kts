import java.net.URI

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral {
        content {
            // just allow to include kotlinx projects
            // detekt needs 'kotlinx-html' for the html report
            includeGroup("io.gitlab.arturbosch.detekt")
            includeGroup("org.jetbrains.kotlinx")
        }
    }
    maven {
        url = URI.create("https://plugins.gradle.org/m2/")
    }
}

dependencies {
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.9.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}