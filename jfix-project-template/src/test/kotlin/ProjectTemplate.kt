import java.io.File

class ProjectTemplate {
    fun mergeBuild(templateFile: File, destFile: File) {
        val result = mergeBuild(
                template = templateFile.readText(),
                dest = destFile.readText())

        destFile.writeText(result)
    }

    enum class Key {
        buildscriptDependencies,
        plugins,
        build;

        companion object {
            fun parseLineForOpenKey(line: String): Key? =
                    values().firstOrNull {
                        line.contains("//<$it>")
                    }

            fun parseLineForCloseKey(line: String): Key? =
                    values().firstOrNull {
                        line.contains("//</$it>")
                    }

        }
    }


    fun parseDest(dest: String): Map<Key, String> {
        val injects = mutableMapOf<Key, String>()

        var curKey: Key? = null
        var curText = StringBuilder()

        for (line in dest.lines()) {
            if (curKey == null) {
                val openKey = Key.parseLineForOpenKey(line)
                if (openKey != null) {
                    curKey = openKey
                }
            } else {
                val closeKey = Key.parseLineForCloseKey(line)
                if (closeKey == null) {
                    if(curText.isNotEmpty()){
                        curText.appendln()
                    }
                    curText.append(line)
                } else {
                    require(curKey == closeKey)
                    injects[curKey] = curText.toString()
                    curText = StringBuilder()
                    curKey = null
                }
            }
        }

        return injects
    }

    fun mergeBuild(template: String, dest: String): String {
        val injects = parseDest(dest)
        val out = StringBuilder()
        for (line in template.lines()) {
            if(out.isNotEmpty()){
                out.appendln()
            }
            out.append(line)

            val openKey = Key.parseLineForOpenKey(line)
            if(openKey != null) {
                injects[openKey]?.let {
                    out.appendln()
                    out.append(it)
                }
            }
        }
        return out.toString();
    }

    fun mergeDependencies(template: File, dest: File) {
        TODO()
    }
}