package cycle4;


import com.marimbacode.simplegraphs.graphs.Graph;
import com.marimbacode.simplegraphs.pathfinding.BreadthFirstSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KevinBacon {
	
	private Graph<String> g;
	private BreadthFirstSearch<String> bfs;
	private Set<String> movies, actors;
	
	public KevinBacon() throws IOException {
		g = new Graph<>();
		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/movies.txt"));
		movies = new HashSet<>();
		actors = new HashSet<>();
		
		String l;
		while((l = reader.readLine()) != null){
			String[] moviesArr = l.split("/");
			
			movies.add(moviesArr[0]);
			for (int i = 1; i < moviesArr.length; i++)
			{
				g.addEdge(moviesArr[0], moviesArr[i]);
				movies.add(moviesArr[i]);
			}
		}
		
		bfs = new BreadthFirstSearch<>(g);
	}
	
	
	public List<String> bacon(String s) {
		return bfs.pathFind(new String[]{s, "Bacon, Kevin"});
	}
	
	public static void main(String[] args) throws IOException {
		
		KevinBacon bacon = new KevinBacon();
		
		double avg = 0;
		int max = 0, numWithoutPath = 0;
		
		for(String s: bacon.actors){
			if(s.equals("Bacon, Kevin")){continue;}
			
			List<String> path = bacon.bacon(s);
			
			int deg = path.size()/2;
			
			if(path.size() != 0)
			{
				avg += deg;
				max = Math.max(deg, max);
			}else{
				numWithoutPath++;
			}
			
		}
		avg /= bacon.actors.size();
		
		
	}
	
	
}