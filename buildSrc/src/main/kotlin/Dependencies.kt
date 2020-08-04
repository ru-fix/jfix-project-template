object Vers {
    //Gradle Plugins
    const val dokkav = "0.10.1"
    const val gradle_release_plugin = "1.3.17"
    const val asciidoctor_plugin = "1.5.9.2"
    const val allure_plugin = "2.8.1"
    const val allure_cli = "2.13.1"
    const val nexus_staging_plugin = "0.21.2"
    const val nexus_publish_plugin = "0.4.0"

    //Dependencies
    // Kotlin
    const val kotlin = "1.3.72"
    const val kotlin_coroutines = "1.3.5"

    // Logging
    const val log4j =  "2.13.3"
    const val log4j_kotlin = "1.0.0"

    // Testing
    const val junit = "5.6.2"
    const val kotest = "4.1.3"
    const val mockk = "1.10.0"
}

object Libs {
    //Plugins
    const val gradle_release_plugin = "ru.fix:gradle-release-plugin:${Vers.gradle_release_plugin}"
    const val dokka_plugin = "org.jetbrains.dokka:dokka-gradle-plugin:${Vers.dokkav}"
    const val nexus_staging_plugin_id = "io.codearte.nexus-staging"
    const val nexus_publish_plugin_id = "de.marcphilipp.nexus-publish"
    const val asciidoctor_plugin_id = "org.asciidoctor.convert"
    const val asciidoctor_plugin = "org.asciidoctor:asciidoctor-gradle-plugin:${Vers.asciidoctor_plugin}"

    //Dependencies
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Vers.kotlin}"
    const val kotlin_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Vers.kotlin}"
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Vers.kotlin}"
    const val kotlinx_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Vers.kotlin_coroutines}"

    const val log4j_core = "org.apache.logging.log4j:log4j-core:${Vers.log4j}"
    const val slf4j_over_log4j = "org.apache.logging.log4j:log4j-slf4j-impl:${Vers.log4j}"
    const val log4j_kotlin = "org.apache.logging.log4j:log4j-api-kotlin:${Vers.log4j_kotlin}"

    // Testing
    const val junit_api = "org.junit.jupiter:junit-jupiter-api:${Vers.junit}"
    const val junit_params = "org.junit.jupiter:junit-jupiter-params:${Vers.junit}"
    const val junit_engine = "org.junit.jupiter:junit-jupiter-engine:${Vers.junit}"
    const val kotest_assertions_core_jvm = "io.kotest:kotest-assertions-core-jvm:${Vers.kotest}"
    const val mockk = "io.mockk:mockk:${Vers.mockk}"

}

enum class Projs{
    `jfix-project-template-subproject`;

    val dependency get(): String = ":$name"
}
