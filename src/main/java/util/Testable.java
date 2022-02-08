package util;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Testable {

    protected String inputFilePath;
    protected String outputFilePath;

    public Testable(String filePath){
        this.inputFilePath = filePath + ".dat";
        this.outputFilePath = filePath + ".out";

        output = new StringBuilder();
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    private final StringBuilder output;

    protected void println(String... out){
        for(String s: out){
            output.append(s);
            System.out.print(s);
        }
        output.append("\n");
        System.out.println();
    }
    protected void print(String out){
        output.append(out);
        System.out.print(out);
    }

    public abstract void test() throws IOException;
    public String getOutput(){
        return output.toString();
    }
}
