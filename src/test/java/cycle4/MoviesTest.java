package cycle4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoviesTest {
    
    @Test
    public final void test0(){
        
        MovieGraph mv = new MovieGraph("src/main/resources/movies.txt");
        
        StringBuilder sb = new StringBuilder();
        for (String s : mv.adjacentTo("'Venganza fatal' (1960)")) {
            sb.append(s).append("/");
        }
        String expected = "Aragón, Luis/Casanova, Fernando/Castro, José (II)/Dondé, Manuel/Garibay, Emilio/González, Felipe (V)/Herrera, Regino/Manrique, Arturo/Marcos, Alberto (I)/María, Dora/Márquez, Rubén/Pandal, Ramón/Pardavé, José/Rachini, Jorge/Ramírez Garza, Roberto/Silvestre, Flor/Zumaya, Amado/";
        assertEquals(sb.toString(), expected);
    
    
    }
    
}
