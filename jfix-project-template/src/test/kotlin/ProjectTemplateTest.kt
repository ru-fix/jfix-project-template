import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.containsSubstring
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.hasSize
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProjectTemplateTest {

    fun resource(name: String) = javaClass.getResource(name).readText()

    @Test
    fun `parse dest build script`(){
        val injects = ProjectTemplate().parseDest(resource("merge1-dest.txt"))
        assertThat(injects.keys, Set<ProjectTemplate.Key>::containsAll, ProjectTemplate.Key.values().toSet())

        injects[ProjectTemplate.Key.buildscriptDependencies]!!.let{
            assertThat(it, containsSubstring("my-buildscript-dependencies-here"))
            assertThat(it.lines(), hasSize(equalTo(1)))
        }

        injects[ProjectTemplate.Key.plugins]!!.let{
            assertThat(it, containsSubstring("my-plugins-here"))
            assertThat(it.lines(), hasSize(equalTo(1)))
        }

        injects[ProjectTemplate.Key.build]!!.let{
            assertThat(it, containsSubstring("my-build-here"))
            assertThat(it.lines(), hasSize(equalTo(1)))
        }
    }

    @Test
    fun `merge build`() {
        val out = ProjectTemplate().mergeBuild(
                resource("merge1-template.txt"),
                resource("merge1-dest.txt")
        )
        Assertions.assertEquals(resource("merge1-out.txt"), out)
    }
}
