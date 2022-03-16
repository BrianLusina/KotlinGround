object Plugins {
    const val JAVA = "java"
    const val KOTLIN = "kotlin"

    const val JACOCO = "jacoco"
    const val JACOCO_PLUGIN = "org.jacoco:org.jacoco.core:${Versions.JACOCO}"

    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val DETEKT_GRADLE = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin"
    const val DETEKT_FORMATTING = "io.gitlab.arturbosch.detekt:detekt-formatting"

    const val dokkaVersion = "1.5.0"
    const val DOKKA_GRADLE= "org.jetbrains.dokka:dokka-gradle-plugin"
    const val dokka = "org.jetbrains.dokka"

    const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val KOTLIN_GRADLE_ALL_OPEN = "org.jetbrains.kotlin:kotlin-allopen:${Versions.KOTLIN}"
    const val KOTLIN_GRADLE_NO_ARGS= "org.jetbrains.kotlin:kotlin-noarg:${Versions.KOTLIN}"
    const val KOTLINX = "org.jetbrains.kotlinx"
}
