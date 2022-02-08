package cycle4;


import com.marimbacode.simplegraphs.graph_nodes.GraphNode;

import java.util.TreeMap;

public class SortedGraphNode<A extends Comparable<A>> extends GraphNode<A> {
    public SortedGraphNode(){
        adjacency = new TreeMap<>();
    }
}
