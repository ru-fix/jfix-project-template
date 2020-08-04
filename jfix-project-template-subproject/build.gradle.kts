import org.gradle.kotlin.dsl.*


plugins {
    java
    kotlin("jvm")
}

dependencies {
    // Kotlin
    implementation(Libs.kotlin_jdk8)
    implementation(Libs.kotlin_stdlib)
    implementation(Libs.kotlin_reflect)

    // Logging
    implementation(Libs.log4j_kotlin)

    // Testing
    //  Junit
    testImplementation(Libs.junit_api)
    testRuntimeOnly(Libs.junit_engine)
    //  Kotest
    testImplementation(Libs.kotest_assertions_core_jvm)
    //  Mocking
    testImplementation(Libs.mockk)
    //  Test Logging
    testRuntimeOnly(Libs.log4j_core)
    testRuntimeOnly(Libs.slf4j_over_log4j)
}
