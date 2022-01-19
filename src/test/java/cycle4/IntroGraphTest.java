package cycle4;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class IntroGraphTest {
    
    @Test
    public final void test0() throws FileNotFoundException {
        
        IntroGraph graph = new IntroGraph("src/main/resources/graph.txt", " ");
        System.out.println(graph.toString());
        
    }
}
