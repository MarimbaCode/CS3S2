package util;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.function.Consumer;

public abstract class Graph<A> implements Iterable<Graph<A>>{
    
    protected final Map<A, GraphNode<A>> nodes = new HashMap<>();
    
    protected GraphNodeFactory<A> factory = new DefaultGraphNodeFactory<>();
    
    protected void addNode(A id, GraphNode<A> node){
        nodes.put(id, node);
    }
    protected void addNode(A id){
        try{
            GraphNode<A> node = factory.newNode();
            node.graph = this;
            node.id = id;
            nodes.put(id, node);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void addEdge(A a, A b){
        GraphNode<A> na, nb;
        na = nodes.get(a);
        nb = nodes.get(b);
        
        if (na == null)
        {
            addNode(a);
            na = nodes.get(a);
        }
        
        if (nb == null)
        {
            addNode(b);
            nb = nodes.get(b);
        }
        na.addConnection(b);
        
    }
    
    protected int getVertecies(){
        return nodes.size();
    }
    
    protected int getEdges(){
        return 0;
    }
    
    protected GraphNode<A> getNode(A id){
        return nodes.get(id);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (A a : nodes.keySet()) {
            sb.append(a).append(": [");
            GraphNode<A> node = nodes.get(a);
            for (A b : node.adjacency.keySet()) {
                sb.append(b).append("-").append(node.adjacency.get(b)).append(",");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
    
    @Override
    public void forEach(Consumer<? super Graph<A>> action) {
        Iterable.super.forEach(action);
    }
    
    @Override
    public Spliterator<Graph<A>> spliterator() {
        return Iterable.super.spliterator();
    }
    
    @Override
    public Iterator<Graph<A>> iterator() {
        return new GraphIterator();
    }
    
    private class GraphIterator<A> implements Iterator<A>{
        
        private final Iterator<A> it = (Iterator<A>) nodes.keySet().iterator();
        
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }
        
        @Override
        public A next() {
            return it.next();
        }
    }
    
    private static class DefaultGraphNodeFactory<A> implements util.GraphNodeFactory<A>{
        @Override
        public GraphNode<A> newNode() {
            return new GraphNode<>();
        }
    }
}
