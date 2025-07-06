import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URI

plugins {
    kotlin("jvm")
    kotlin("kapt")
}

allprojects {
    group = "com.kotlinground"
    version = Versions.PROJECT

    apply(plugin = Plugins.JACOCO)
    apply(plugin = Plugins.JAVA)
    apply(plugin = Plugins.DETEKT)

    repositories {
        mavenCentral()
        maven { url = URI.create("https://jitpack.io") }
        maven { url = URI.create("https://plugins.gradle.org/m2/") }
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_16
    }

    configure<JacocoPluginExtension> {
        toolVersion = Versions.JACOCO
        reportsDirectory.set(file("${layout.buildDirectory}/reports/jacoco"))
    }
}

subprojects {
    buildscript {
        repositories {
            mavenCentral()
        }

        dependencies {
        }
    }

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("jacoco")
//        plugin(Plugins.KOTLINX_BENCHMARK)
    }

    repositories {
        mavenCentral()
        flatDir {
            dirs("libs")
        }
        maven { url = URI.create("https://jitpack.io") }
        maven { url = URI.create("https://plugins.gradle.org/m2/") }
    }

    tasks {
        withType<JavaCompile> {
            sourceCompatibility = "${JavaVersion.VERSION_11}"
            targetCompatibility = "${JavaVersion.VERSION_11}"
        }

        withType<KotlinCompile> {
            compilerOptions {
                freeCompilerArgs.set(listOf("-Xjsr305=strict", "-Xopt-in=kotlin.RequiresOptIn"))
                jvmTarget.set(JvmTarget.JVM_11)
            }
        }

        compileTestKotlin {
            compilerOptions.jvmTarget.set(JvmTarget.JVM_11)
        }

        withType<Test> {
            useJUnitPlatform {
//                TODO: including this engine fails test discovery
//                includeEngines = setOf("spek2")
            }

            testLogging {
                events("failed")
                showExceptions = true
                showCauses = true
                showStackTraces = true
            }

            finalizedBy(tasks.findByName("jacocoTestReport"))
        }
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8", Versions.KOTLIN))

        testRuntimeOnly(Dependencies.Test.kotlinReflect)

        testImplementation(Dependencies.Test.kotlinTestJunit)
        testImplementation(Dependencies.Test.jUnitJupiterApi)
        testImplementation(Dependencies.Test.jUnitJupiter)
        testImplementation(Dependencies.Test.mockK)
        testImplementation(Dependencies.Test.spekDslJvm)
        testImplementation(Dependencies.Test.jUnitJupiterEngine)
        testImplementation(Dependencies.Test.jUnitJupiterVintageEngine)
        testImplementation(Dependencies.Test.koTest)
        testImplementation(Dependencies.Test.koTestProperty)
        testImplementation(Dependencies.Test.koTestAssertions)
        testImplementation(Dependencies.Test.koTestFrameworkDataTest)
//        testRuntimeOnly(Dependencies.Test.spekRunnerJunit5)
    }
}

tasks {
    withType<Wrapper> {
        distributionType = Wrapper.DistributionType.ALL
        gradleVersion = Versions.GRADLE
    }
}
