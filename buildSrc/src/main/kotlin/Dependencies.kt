object Vers {
    //Plugins
    val dokkav = "0.9.18"
    val gradle_release_plugin = "1.3.15"
    val asciidoctor = "1.5.9.2"
    val allure_plugin = "2.8.1"
    val allure_cli = "2.13.1"

    //Dependencies
    val kotlin = "1.3.61"
    val kotlin_coroutines = "1.3.4"
    val junit = "5.6.0"
    val sl4j = "1.7.30"
    const val log4j =  "2.13.1"
}

object Libs {
    //Plugins
    val gradle_release_plugin = "ru.fix:gradle-release-plugin:${Vers.gradle_release_plugin}"
    val dokka_gradle_plugin = "org.jetbrains.dokka:dokka-gradle-plugin:${Vers.dokkav}"
    val nexus_staging_plugin = "io.codearte.nexus-staging"
    val nexus_publish_plugin = "de.marcphilipp.nexus-publish"
    val asciidoctor = "org.asciidoctor:asciidoctor-gradle-plugin:${Vers.asciidoctor}"

    //Dependencies
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Vers.kotlin}"
    val kotlin_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Vers.kotlin}"
    val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Vers.kotlin}"
    val kotlinx_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Vers.kotlin_coroutines}"

    const val slf4j_api = "org.slf4j:slf4j-api:${Vers.sl4j}"
    const val log4j_core = "org.apache.logging.log4j:log4j-core:${Vers.log4j}"
    const val slf4j_over_log4j = "org.apache.logging.log4j:log4j-slf4j-impl:${Vers.log4j}"
    const val mu_kotlin_logging = "io.github.microutils:kotlin-logging:1.7.8"

    val kotlin_logging = "io.github.microutils:kotlin-logging:1.7.8"

    val junit_api = "org.junit.jupiter:junit-jupiter-api:${Vers.junit}"
    val junit_params = "org.junit.jupiter:junit-jupiter-params:${Vers.junit}"
    val junit_engine = "org.junit.jupiter:junit-jupiter-engine:${Vers.junit}"

}

enum class Projs{
    `jfix-project-template-subproject`;

    val dependency get(): String = ":$name"
}
