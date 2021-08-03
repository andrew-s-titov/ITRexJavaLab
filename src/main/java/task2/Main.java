package task2;

public class Main {
    public static void main(String[] args) {
        FileParser parser = new FileParser("src/main/resources/INPUT.txt");
        PathTimeFinder princePath = new PathTimeFinder(parser.getField(), parser.getPrince(), parser.getPrincess());
        System.out.println(princePath.getTime(5));
    }
}
