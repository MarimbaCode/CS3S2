package util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class IOMatchTest {

    public void test(Testable t) {

        try {


            t.test();

            Scanner outFile = new Scanner(new File(t.outputFilePath));

            StringBuilder sb = new StringBuilder();

            while (outFile.hasNextLine()) {
                sb.append(outFile.nextLine());
                sb.append("\n");
            }

            String actual = t.getOutput();

            assertEquals(sb.toString().trim(), actual.trim());
        }catch (IOException e){
            e.printStackTrace();
            fail();
        }
    }


}
