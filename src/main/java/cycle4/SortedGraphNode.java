package cycle4;

import util.GraphNode;

import java.util.TreeMap;

public class SortedGraphNode<A> extends GraphNode<Comparable<A>> {
    
    public SortedGraphNode(){
        adjacency = new TreeMap<>();
    }
}
