package task2;

public class Main {
    public static void main(String[] args) {
        PathTimeFinder princePath = new PathTimeFinder("src/main/resources/INPUT.txt");
        System.out.println(princePath.getTime(5));
    }
}
