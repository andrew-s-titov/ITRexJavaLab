package task2;

import org.junit.jupiter.api.*;

public class PrinceOfPersiaTest {

    PathTimeFinder princePath;

    @Test
    @DisplayName("* * * Testing example INPUT.txt * * *")
    public void findPath() {
        String file = "src/main/resources/INPUT.txt";
        princePath = new PathTimeFinder(file);
        Assertions.assertEquals(60, princePath.getTime(5));
    }

    @Test
    @DisplayName("* * * Testing INPUT_test1.txt * * *")
    public void findPath1() {
        String file = "src/main/resources/INPUT_test1.txt";
        princePath = new PathTimeFinder(file);
        Assertions.assertEquals(125, princePath.getTime(5));
    }

    @Test
    @DisplayName("* * * Testing INPUT_test2.txt * * *")
    public void findPath2() {
        String file = "src/main/resources/INPUT_test2.txt";
        princePath = new PathTimeFinder(file);
        Assertions.assertEquals(65, princePath.getTime(5));
    }

    @Test
    @DisplayName("* * * Testing INPUT_test3.txt (this file doesn't meet requirements) * * *")
    public void findPath3() {
        String file = "src/main/resources/INPUT_test3.txt";
        princePath = new PathTimeFinder(file);
        Assertions.assertThrows(IllegalArgumentException.class, () -> princePath.getTime(5));
    }
}
