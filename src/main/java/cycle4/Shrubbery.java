package cycle4;

import util.Testable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Shrubbery extends Testable {

    public Shrubbery(String filePath) {
        super(filePath);
    }

    @Override
    public void test() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(inputFilePath));

        int cases = scanner.nextInt();
        int shrubTotalCount = 1;
        for (int i = 0; i < cases; i++) {
            
            int shrubCount = scanner.nextInt();
            scanner.nextLine();

            List<Shrub> shrubs = new ArrayList<>();

            for (int j = 0; j < shrubCount; j++) {
                shrubs.add(new Shrub(scanner.next(),scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble()));
                scanner.nextLine();
            }

            switch (scanner.next()){
                case "SIZE" ->{
                    shrubs.forEach(s -> s.ratingType = RatingType.SIZE);
                }
                case "PRICE" ->{
                    shrubs.forEach(s -> s.ratingType = RatingType.COST);
                }
                case "NICE" ->{
                    shrubs.forEach(s -> s.ratingType = RatingType.NICE);
                }
            }

            Collections.sort(shrubs);

            for (Shrub shrub : shrubs) {
                println(shrub.name);
            }
            println();

        }



    }

    private enum RatingType{
        SIZE,
        NICE,
        COST
    }

    private static final class Shrub implements Comparable<Shrub>{

        private String name;
        private int nice;
        private double size, cost;
        private RatingType ratingType;

        public Shrub(String name, int nice, double cost, double size) {
            this.name = name;
            this.nice = nice;
            this.size = size;
            this.cost = cost;
        }

        public int getNice() {
            return nice;
        }

        public void setNice(int nice) {
            this.nice = nice;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public RatingType getRatingType() {
            return ratingType;
        }

        public void setRatingType(RatingType ratingType) {
            this.ratingType = ratingType;
        }

        @Override
        public int compareTo(Shrub o) {
            switch (ratingType){
                case COST -> {
                    return -Double.compare(o.cost, this.cost);
                }
                case NICE -> {
                    return Integer.compare(o.nice, this.nice);
                }
                case SIZE -> {
                    return Double.compare(o.size, this.size);
                }
                default -> {return 0;}
            }
        }
    }



}
