package cycle4;

import org.junit.jupiter.api.Test;
import util.IOMatchTest;
import util.Testable;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class StudentsTest extends IOMatchTest {

    @Test
    public final void test0() {
        Testable sortingStudents = new SortingStudents("src/main/resources/students");
        test(sortingStudents);
    }



}
