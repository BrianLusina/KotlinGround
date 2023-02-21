object Dependencies {
    object Utils {
        object Jetbrains {
            val kotlinXDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"
        }
    }

    object Test {
        const val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.KOTLIN}"
        const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"

        const val jUnitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine"
        const val jUnitJupiterVintageEngine = "org.junit.vintage:junit-vintage-engine"
        const val jUnitJupiterApi = "org.junit.jupiter:junit-jupiter-api:5.7.1"
        const val mockK = "io.mockk:mockk:1.11.0"

        private const val spekVersion = "2.0.17"
        const val spekDslJvm = "org.spekframework.spek2:spek-dsl-jvm:$spekVersion"
        const val spekRunnerJunit5 = "org.spekframework.spek2:spek-runner-junit5:$spekVersion"
    }
}
