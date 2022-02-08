package cycle4;

import com.marimbacode.simplegraphs.graphs.Graph;
import com.marimbacode.simplegraphs.pathfinding.BreadthFirstSearch;
import util.Testable;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Rats extends Testable {
	
	
	public Rats(String filePath) {
		super(filePath);
	}
	
	@Override
	public void test() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/rat.dat")));
		
		int cases = Integer.parseInt(reader.readLine());
		
		for (int spaghetti = 0; spaghetti < cases; spaghetti++)
		{
			String[] dim = reader.readLine().split(" ");
			int w = Integer.parseInt(dim[1]), h = Integer.parseInt(dim[0]);
			
			String[][] map = new String[h][w];
			
			int[] start = new int[]{-1,-1}, end = new int[]{-1,-1};
			for (int i = 0; i < h; i++)
			{
				String line = reader.readLine();
				int pos;
				if((pos = line.indexOf("S")) >= 0){
					start = new int[]{i, pos};
				}
				if((pos = line.indexOf("E")) >= 0){
					end = new int[]{i, pos};
				}
				map[i] = line.split("");
			}
			
			Graph<String> g = new Graph<>();
			
			for (int i = 0; i < h - 1; i++)
			{
				for (int j = 0; j < w; j++)
				{
					if(!(map[i][j].equals("G")||map[i+1][j].equals("G"))){
						g.addEdge(Arrays.toString(new int[]{i,j}), Arrays.toString(new int[]{i+1,j}));
					}
				}
			}
			for (int i = 0; i < h; i++)
			{
				for (int j = 0; j < w - 1; j++)
				{
					if(!(map[i][j].equals("G")||map[i][j+1].equals("G"))){
						g.addEdge(Arrays.toString(new int[]{i,j}), Arrays.toString(new int[]{i,j+1}));
						
					}
				}
			}
			if(Arrays.equals(start, new int[]{-1,-1}) || Arrays.equals(end, new int[]{-1,-1})){
				println("Oh Rem please help me");
			}else
			{
				BreadthFirstSearch<String> search = new BreadthFirstSearch<>(g);
				List<String> path = search.pathFind(new String[]{Arrays.toString(start), Arrays.toString(end)});
				if (path == null || path.size() == 0)
				{
					println("Oh Rem please help me");
				} else
				{
					println(path.size() - 1 + " seconds");
				}
			}
		}
	}
}
