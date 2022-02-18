package cycle5;

import util.Testable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BubblePop extends Testable {
	public BubblePop(String filePath) {
		super(filePath);
	}
	
	byte[][] map;
	
	@Override
	public void test() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
		map = new byte[10][10];
		for (int i = 0; i < 10; i++)
		{
			String[] s = reader.readLine().split("");
			for (int j = 0; j < 10; j++)
			{
				switch (s[j]){
					case "A" -> map[i][j] = 0;
					case "B" -> map[i][j] = 1;
					case "C" -> map[i][j] = 2;
					case "D" -> map[i][j] = 3;
					case "E" -> map[i][j] = 4;
				}
			}
		}
		int cases = Integer.parseInt(reader.readLine());
		for (int i = 0; i < cases; i++)
		{
			int y, x;
			String l = reader.readLine();
			y = Integer.parseInt(l.split(" ")[0]);
			x = Integer.parseInt(l.split(" ")[1]);
			
			int fillSize;
			if((fillSize = fill(y,x, map[y][x], new HashSet<>())) >= 3){
				println("YES " + fillSize);
			}else{
				println("NO");
			}
			
		
		}
		
		
		
	
	}
	
	public int fill(int y, int x, byte c, Set<Pair> visited){
		int toReturn = 1;
		
		if(map[y][x] != c){return 0;}
		
		if(visited.contains(new Pair(y,x))){return 0;}
		visited.add(new Pair(y,x));
		
		if(y != 0){toReturn += fill(y-1, x, c, visited);}
		if(y != 9){toReturn += fill(y+1, x, c, visited);}
		if(x != 0){toReturn += fill(y, x-1, c, visited);}
		if(x != 9){toReturn += fill(y, x+1, c, visited);}
		
		return toReturn;
	}
	private record Pair(int y, int x){}
}
