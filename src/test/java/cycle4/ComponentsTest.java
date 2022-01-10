package cycle4;

import org.junit.jupiter.api.Test;
import util.IOMatchTest;
import util.Testable;

public class ComponentsTest extends IOMatchTest {

    @Test public final void test0(){
        Testable t = new Components("src/main/resources/components");
        test(t);
    }
}
