object Vers {
    //Plugins
    val dokkav = "0.9.18"
    val gradle_release_plugin = "1.3.9"
    val asciidoctor = "1.5.9.2"

    //Dependencies
    val kotlin = "1.3.41"
    val kotlin_coroutines = "1.2.2"
    val junit = "5.2.0"
    val sl4j = "1.7.25"
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

    val slf4j_api = "org.slf4j:slf4j-api:${Vers.sl4j}"
    val slf4j_simple = "org.slf4j:slf4j-simple:${Vers.sl4j}"

    val kotlin_logging = "io.github.microutils:kotlin-logging:1.4.9"

    val junit_api = "org.junit.jupiter:junit-jupiter-api:${Vers.junit}"
    val junit_params = "org.junit.jupiter:junit-jupiter-params:${Vers.junit}"
    val junit_engine = "org.junit.jupiter:junit-jupiter-engine:${Vers.junit}"

    val hamkrest = "com.natpryce:hamkrest:1.7.0.0"
}

enum class Projs{
    jfix_project_template,
    jfix_project_template_subproject;

    val directory get() = this.name.replace('_', '-')
    val dependency get(): String = ":$directory"
}
