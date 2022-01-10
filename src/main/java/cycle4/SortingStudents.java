package cycle4;

import util.Testable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingStudents extends Testable {


    public SortingStudents(String filePath) {
        super(filePath);
    }

    @Override
    public void test() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(inputFilePath));

        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {

            List<Student> students = new ArrayList<>();

            int names = scanner.nextInt();
            for (int j = 0; j < names; j++) {
                students.add(new Student(scanner.next(), scanner.nextInt()));
                scanner.nextLine();
            }

            Collections.sort(students);

            students.forEach(s -> println(s.toString()));
            println();

        }


    }

    private static final class Student implements Comparable<Student>{

        private int grade;
        private String name;

        public Student(String name, int grade) {
            this.grade = grade;
            this.name = name;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            return -Integer.compare(this.grade, o.grade);
        }

        @Override
        public String toString() {
            return name + " " + grade;
        }
    }

}
