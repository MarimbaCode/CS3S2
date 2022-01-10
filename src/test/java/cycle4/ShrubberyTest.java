package cycle4;

import org.junit.jupiter.api.Test;
import util.IOMatchTest;
import util.Testable;

public class ShrubberyTest extends IOMatchTest {

    @Test public final void test0(){

        Testable t = new Shrubbery("src/main/resources/shrubbery");
        test(t);

    }

}
