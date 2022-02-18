package cycle5;

import org.junit.jupiter.api.Test;
import util.IOMatchTest;
import util.Testable;

public class BubblePopTest extends IOMatchTest {
	
	@Test
	public final void test0(){
		Testable t = new BubblePop("src/main/resources/bubble");
		test(t);
	}
}
