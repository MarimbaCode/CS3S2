package util;

import com.marimbacode.simplegraphs.graph_nodes.GraphNode;
import com.marimbacode.simplegraphs.graph_nodes.GraphNodeFactory;
import com.marimbacode.simplegraphs.util.Pair;
import cycle4.SortedGraphNode;

public class SortedGraphNodeFactory<A extends Comparable<A>> implements GraphNodeFactory<A> {
    
    @Override
    public GraphNode<A> newNode() {
        return new SortedGraphNode<>();
    }
    
    @Override
    public Pair<A> newPair(A a, A a1) {
        return new Pair<>(a, a1);
    }
}
