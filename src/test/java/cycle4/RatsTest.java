package cycle4;

import org.junit.jupiter.api.Test;
import util.IOMatchTest;
import util.Testable;

public class RatsTest extends IOMatchTest {
	
	@Test
	public final void test0(){
		Testable t = new Rats("src/main/resources/rat");
		test(t);
	}
	
}
