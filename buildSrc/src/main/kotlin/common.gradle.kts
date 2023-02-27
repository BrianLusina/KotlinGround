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
        sourceCompatibility = JavaVersion.VERSION_11
    }

    configure<JacocoPluginExtension> {
        toolVersion = Versions.JACOCO
        reportsDirectory.set(file("${buildDir}/reports/jacoco"))
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
    }

    repositories {
        mavenCentral()
        flatDir {
            dirs("libs")
        }
        maven { url = URI.create("https://jitpack.io") }
//        maven { url = URI.create("http://dl.bintray.com/jetbrains/spek") }
        maven { url = URI.create("https://plugins.gradle.org/m2/") }
    }

    tasks {
        withType<JavaCompile> {
            sourceCompatibility = "${JavaVersion.VERSION_11}"
            targetCompatibility = "${JavaVersion.VERSION_11}"
        }

        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict", "-Xopt-in=kotlin.RequiresOptIn")
                jvmTarget = "${JavaVersion.VERSION_11}"
            }
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = "${JavaVersion.VERSION_11}"
        }

        withType<Test> {
            useJUnitPlatform {
//                TODO: including this engine fails test discovery
                includeEngines = setOf("spek2")
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

        testImplementation(Dependencies.Test.kotlinTestJunit)
        testImplementation(Dependencies.Test.jUnitJupiterApi)
        testImplementation(Dependencies.Test.mockK)
        testImplementation(Dependencies.Test.spekDslJvm)
        testImplementation(Dependencies.Test.kotlinReflect)
        testImplementation(Dependencies.Test.spekRunnerJunit5)
        testImplementation(Dependencies.Test.jUnitJupiterEngine)
        testImplementation(Dependencies.Test.jUnitJupiterVintageEngine)
    }
}

tasks {
    withType<Wrapper> {
        distributionType = Wrapper.DistributionType.ALL
        gradleVersion = Versions.GRADLE
    }
}
