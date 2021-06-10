object Plugins {
    const val JAVA = "java"
    const val KOTLIN = "kotlin"

    const val JACOCO = "jacoco"
    val JACOCO_PLUGIN = "org.jacoco:org.jacoco.core:${Versions.JACOCO}"

    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val DETEKT_GRADLE = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin"
    const val DETEKT_FORMATTING = "io.gitlab.arturbosch.detekt:detekt-formatting"

    const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val KOTLINX = "org.jetbrains.kotlinx"
}
