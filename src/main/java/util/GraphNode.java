package util;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GraphNode<A> {
    public Graph<A> graph;
    public A id;
    public Map<A, Integer> adjacency;
    
    public GraphNode() {
        adjacency = new HashMap<>();
    }
    
    public void addConnection(A oId){
        Integer connCount = adjacency.get(oId);
        if(connCount == null){
            connCount = 0;
        }
        adjacency.put(oId, ++connCount);
        
        GraphNode<A> o = graph.nodes.get(oId);
        Integer oConnCount = o.adjacency.get(id);
        if(oConnCount == null){
            oConnCount = 0;
        }
        o.adjacency.put(id, ++oConnCount);
    }
    
}