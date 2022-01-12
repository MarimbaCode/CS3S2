package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class Graph<A, B> implements Iterable<Graph<A, B>>{
	
	private final Map<A, GraphNode> nodes = new HashMap<>();
	
	protected void addNode(A id, GraphNode node){
		nodes.put(id, node);
	}
	
	protected void getNode(A id){
		return ;
	}
	
	
	protected static class GraphNode {
	
	}
	
	@Override
	public void forEach(Consumer<? super Graph<A, B>> action) {
		Iterable.super.forEach(action);
	}
	
	@Override
	public Spliterator<Graph<A, B>> spliterator() {
		return Iterable.super.spliterator();
	}
	
	@Override
	public Iterator<Graph<A, B>> iterator() {
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
}
