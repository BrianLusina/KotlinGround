import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("io.gitlab.arturbosch.detekt")
}

val analysisDir = file(projectDir)
val configFile = file("$rootDir/detekt.yml")

val kotlinFiles = "**/*.kt"
val kotlinScriptFiles = "**/*.kts"
val resourceFiles = "**/resources/**"
val buildFiles = "**/build/**"

subprojects {
    apply {
        plugin(Plugins.DETEKT)
    }

    detekt {
//        buildUponDefaultConfig = true
        config.setFrom(listOf(configFile))
//        profile("main") {
//            input = "$projectDir/app/src/main/kotlin"
//            output = "$projectDir/reports/report.xml"
//            // outputFormat = "xml"
//            config = "$rootDir/detekt.yml"
//            filters = ".*test.*,.*/resources/.*,.*/tmp/.*"
//            parallel = true
//        }
//        idea {
//            path = "$USER_HOME/$IDEA_PATH"
//            codeStyleScheme = "$USER_HOME/$IDEA_PATH/config/codestyles/Default.xml"
//            inspectionsProfile = "$USER_HOME/$IDEA_PATH/inspection/Default.xml"
//            report = "project.projectDir/reports"
//            mask = "*.kt,"
//        }
    }

    tasks.withType<Detekt> {
        jvmTarget = "16.0.0"
    }
}

allprojects {
    repositories {
        mavenCentral {
            content {
                // just allow to include kotlinx projects
                // detekt needs 'kotlinx-html' for the html report
                includeGroup(Plugins.DETEKT)
                includeGroup(Plugins.KOTLINX)
            }
        }
        mavenCentral()
    }

    tasks.getByName<DefaultTask>("check") {
        dependsOn.removeIf { it is TaskProvider<*> && it.name == "detekt" }
    }

    dependencies {
        detektPlugins("${Plugins.DETEKT_FORMATTING}:${Versions.DETEKT}")
    }
}

val detektFormat by tasks.registering(Detekt::class) {
    description = "Formats whole project."
    parallel = true
    disableDefaultRuleSets = true
    buildUponDefaultConfig = true
    autoCorrect = true
    setSource(analysisDir)
    include(kotlinFiles)
    //include(kotlinScriptFiles)
    exclude(resourceFiles)
    exclude(buildFiles)
    config.setFrom(listOf(configFile))
    reports {
        htmlReportFile
        xml.enabled = false
        html.enabled = false
        txt.enabled = false
    }
}

val detektAll by tasks.registering(Detekt::class) {
    description = "Runs the whole project at once."
    parallel = true
    buildUponDefaultConfig = true
    setSource(analysisDir)
    include(kotlinFiles)
    //include(kotlinScriptFiles)
    exclude(resourceFiles)
    exclude(buildFiles)
    config.setFrom(listOf(configFile))
    reports {
        xml.enabled = false
        html.enabled = false
        txt.enabled = false
    }
}

tasks.getByName<DefaultTask>("check") {
    dependsOn.add(detektAll)
}