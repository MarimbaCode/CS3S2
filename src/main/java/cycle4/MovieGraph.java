package cycle4;

import util.SortedGraphNodeFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MovieGraph extends IntroGraph{
    
    public MovieGraph(String filename){
        factory = new SortedGraphNodeFactory<>();
        try{
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
        
            String line = scanner.nextLine();
        
            String[] stuff = line.split("/");
        
            for(int i = 1; i < stuff.length; i++){
                addEdge(stuff[0], stuff[i]);
            }
        }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
