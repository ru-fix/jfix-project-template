rootProject.name = "jfix-project-template"

for(project in listOf(
        "jfix-project-template-subproject")) {

    include(project)
}