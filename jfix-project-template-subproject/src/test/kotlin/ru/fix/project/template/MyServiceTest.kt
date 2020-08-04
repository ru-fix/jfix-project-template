import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class MyServiceTest {
    @Test
    fun test() {
        MyService().hello() shouldBe "hello"
    }
}