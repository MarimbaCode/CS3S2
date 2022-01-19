package util;

import cycle4.SortedGraphNode;

public class SortedGraphNodeFactory<A> implements GraphNodeFactory<A>{
    
    @Override
    public GraphNode<A> newNode() {
        return (GraphNode<A>) new SortedGraphNode<A>();
    }
}
