object Dependencies {
    object Jetbrains {
        val kotlinXDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"
        val kotlinXCollectionsImmutable = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5"
        val kotlinXSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0-RC"

        object Coroutines {
            val version = "1.8.1-Beta"
            val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Test {
        const val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.KOTLIN}"
        const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"

        private const val koTestVersion = "5.9.1"
        const val koTest = "io.kotest:kotest-runner-junit5:$koTestVersion"
        const val koTestProperty = "io.kotest:kotest-property:$koTestVersion"
        const val koTestAssertions = "io.kotest:kotest-assertions-core:$koTestVersion"
        const val koTestFrameworkDataTest = "io.kotest:kotest-framework-datatest:$koTestVersion"

        const val jUnitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine"
        const val jUnitJupiterVintageEngine = "org.junit.vintage:junit-vintage-engine"
        const val jUnitJupiterApi = "org.junit.jupiter:junit-jupiter-api:5.8.1"
        const val jUnitJupiter = "org.junit.jupiter:junit-jupiter:5.8.1"
        const val mockK = "io.mockk:mockk:1.11.0"

        private const val spekVersion = "2.0.19"
        const val spekDslJvm = "org.spekframework.spek2:spek-dsl-jvm:$spekVersion"
        const val spekRunnerJunit5 = "org.spekframework.spek2:spek-runner-junit5:$spekVersion"
    }
}
