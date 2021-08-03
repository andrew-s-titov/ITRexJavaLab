package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
I'm aware of the fact that tests should check code logic and shouldn't read files and I know that in case we'll need to
read field params from other sources (e.g. from a server) it will be necessary to rewrite these test.
Nevertheless I decided to use them for quick-check.
 */

public class PrinceOfPersiaTest {

    PathTimeFinder princePath;
    FileParser parser;

    @Test
    @DisplayName("* * * Testing example INPUT.txt * * *")
    public void findPath() {
        String file = "src/main/resources/INPUT.txt";
        parser = new FileParser(file);
        princePath = new PathTimeFinder(parser.getField(), parser.getPrince(), parser.getPrincess());
        Assertions.assertEquals(60, princePath.getTime(5));
    }

    @Test
    @DisplayName("* * * Testing INPUT_test1.txt * * *")
    public void findPath1() {
        String file = "src/main/resources/INPUT_test1.txt";
        parser = new FileParser(file);
        princePath = new PathTimeFinder(parser.getField(), parser.getPrince(), parser.getPrincess());
        Assertions.assertEquals(125, princePath.getTime(5));
    }

    @Test
    @DisplayName("* * * Testing INPUT_test2.txt * * *")
    public void findPath2() {
        String file = "src/main/resources/INPUT_test2.txt";
        parser = new FileParser(file);
        princePath = new PathTimeFinder(parser.getField(), parser.getPrince(), parser.getPrincess());
        Assertions.assertEquals(65, princePath.getTime(5));
    }

    @Test
    @DisplayName("* * * Testing INPUT_test3.txt (this file doesn't meet requirements) * * *")
    public void findPath3() {
        String file = "src/main/resources/INPUT_test3.txt";
        parser = new FileParser(file);
        princePath = new PathTimeFinder(parser.getField(), parser.getPrince(), parser.getPrincess());
        Assertions.assertThrows(IllegalArgumentException.class, () -> princePath.getTime(5));
    }
}
