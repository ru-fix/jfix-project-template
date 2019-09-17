rootProject.name = "jfix-project-template"

Projs.values().forEach {
    include(it.directory)
}