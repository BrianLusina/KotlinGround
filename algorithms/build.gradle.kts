plugins {
    idea
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":ktstrings"))
    implementation(project(":ktmath"))
    implementation(project(":datastructures"))
}
