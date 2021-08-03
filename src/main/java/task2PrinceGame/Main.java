package task2PrinceGame;

public class Main {
    public static void main(String[] args) {
        PathTimeFinder p = new PathTimeFinder("src/main/resources/INPUT_test3.txt");
        System.out.println(p.getTime(5));
    }
}
