package cycle4;


import com.marimbacode.simplegraphs.graphs.Graph;
import com.marimbacode.simplegraphs.pathfinding.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AirlinesSearch {

  public String[] findFlights(String start, String end) throws IOException {
    
      BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/airline.txt"));
      
      Graph<String> g = new Graph<>();
      String l;
      while((l = reader.readLine()) != null){
          String[] airports = l.split(" ");
          g.addEdge(airports[0], airports[1]);
      }
    
      BreadthFirstSearch<String> search = new BreadthFirstSearch<>(g);
      return search.pathFind(new String[]{start, end}).toArray(String[]::new);
  }
}
