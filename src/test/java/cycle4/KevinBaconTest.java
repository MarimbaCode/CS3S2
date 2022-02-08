package cycle4;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KevinBaconTest {
	
	@Test
	public final void test0() throws IOException {
		
		KevinBacon bacon = new KevinBacon();
		
		List<String> l = bacon.bacon("Orina, Dennis");
		
		assertEquals(3, l.size());
		
		
		
	}
}
