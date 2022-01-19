package cycle4;

import util.Graph;
import util.GraphNode;
import util.GraphNodeFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class IntroGraph extends Graph<String> {
    
    public IntroGraph() {}
    
    public IntroGraph(String filename, String delimiter) throws FileNotFoundException {
        
        Scanner scanner = new Scanner(new File(filename));
        
        while (scanner.hasNextLine()) {
            
            String line = scanner.nextLine();
            
            String[] stuff = line.split(delimiter);
            
            for(int i = 1; i < stuff.length; i++){
                addEdge(stuff[0], stuff[i]);
            }
        }
    }
    
    public int V() {
        return getVertecies();
    }
    
    public int E() {
        return 0;
    }
    
    public Iterable<String> verticies(){
        return nodes.keySet();
    }
    
    public Iterable<String> adjacentTo(String v){
        return getNode(v).adjacency.keySet();
    }
    
    public int degree(String id){
        return nodes.get(id).adjacency.size();
    }
    
    public boolean hasVertex(String id){
        return nodes.get(id) != null;
    }
    
    public boolean hasEdge(String id1, String id2){
        return nodes.get(id1).adjacency.containsKey(id2);
    }
    
}
