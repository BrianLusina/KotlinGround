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
        jcenter()
        mavenCentral()
        maven { url = URI.create("https://jitpack.io") }
        maven { url = URI.create("http://dl.bintray.com/typesafe/maven-releases") }
        maven { url = URI.create("https://plugins.gradle.org/m2/") }
    }

    configure<JavaPluginConvention> {
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
            jcenter()
            mavenCentral()
        }

        dependencies {
//            classpath(Plugins.springBootGradlePlugin)
        }
    }

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("jacoco")
    }

    repositories {
        mavenCentral()
        jcenter()
        flatDir {
            dirs("libs")
        }
        maven { url = URI.create("https://jitpack.io") }
        maven { url = URI.create("http://dl.bintray.com/typesafe/maven-releases") }
        maven { url = URI.create("http://dl.bintray.com/jetbrains/spek") }
        maven { url = URI.create("https://plugins.gradle.org/m2/") }
    }

    tasks {

        withType<JavaCompile> {
            sourceCompatibility = "${JavaVersion.VERSION_11}"
            targetCompatibility = "${JavaVersion.VERSION_11}"
        }

        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "${JavaVersion.VERSION_11}"
            }
        }

        withType<Test> {
            useJUnitPlatform {
                includeEngines = setOf("spek", "spek2")
                // Set the property includeIntegration to include integration tests e.g.
                // ./gradlew test -PincludeIntegration
                val includeIntegration: String? by project
                val shouldInclude = project.hasProperty("includeIntegration") && includeIntegration != "false"
                if (!shouldInclude) {
                    excludeTags = setOf("integration")
                }
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

//    implementation(fileTree(dir to "libs", include= "*.jar"))

//    codacy "com.github.codacy:codacy-coverage-reporter:-SNAPSHOT"

        implementation(kotlin("stdlib-jdk8", Versions.KOTLIN))
        testImplementation(Libs.Test.kotlinTestJunit)
        testImplementation(Libs.Test.jUnitJupiterApi)
        testImplementation(Libs.Test.jUnitJupiterEngine)
        testImplementation(Libs.Test.mockK)
        testImplementation(Libs.Test.spekDslJvm)
        testImplementation(Libs.Test.spekRunnerJunit5)
    }
}

tasks {
    withType<Wrapper> {
        distributionType = Wrapper.DistributionType.ALL
        gradleVersion = Versions.GRADLE
    }
}
