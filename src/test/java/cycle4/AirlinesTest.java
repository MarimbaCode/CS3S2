package cycle4;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AirlinesTest {
    
    @Test
    public final void test0() throws IOException {
        
        AirlinesSearch search = new AirlinesSearch();
        
        String[] flights;
        
        flights = search.findFlights("JFK", "LAX");
        assertEquals(4, flights.length);
        
        flights = search.findFlights("HOU", "JFK");
        assertEquals(3, flights.length);
        
        flights = search.findFlights("LAS", "MCO");
        assertEquals(5, flights.length);
    }
}
