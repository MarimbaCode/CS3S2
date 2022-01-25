package cycle4;

import com.marimbacode.graph.GraphNode;

import java.util.TreeMap;

public class SortedGraphNode<A> extends GraphNode<Comparable<A>> {
    
    public SortedGraphNode(){
        adjacency = new TreeMap<>();
    }
}
