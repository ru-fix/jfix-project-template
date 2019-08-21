import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.Test

class MyServiceTest{
    @Test
    fun test(){
        assertThat(MyService().hello(), equalTo("hello"))
    }
}