import org.junit.jupiter.api.*;
import task2PrinceGame.PathTimeFinder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PrinceOfPersiaTest {

    PathTimeFinder p;

    @Test
    @Order(1)
    @DisplayName("* * * Testing example INPUT.txt * * *")
    public void findPath() {
        String file = "src/main/resources/INPUT.txt";
        p = new PathTimeFinder(file);
        Assertions.assertEquals(60, p.getTime(5));
    }

    @Test
    @Order(2)
    @DisplayName("* * * Testing example INPUT_test1.txt * * *")
    public void findPath1() {
        String file = "src/main/resources/INPUT_test1.txt";
        p = new PathTimeFinder(file);
        Assertions.assertEquals(125, p.getTime(5));
    }

    @Test
    @Order(3)
    @DisplayName("* * * Testing example INPUT_test2.txt * * *")
    public void findPath2() {
        String file = "src/main/resources/INPUT_test2.txt";
        p = new PathTimeFinder(file);
        Assertions.assertEquals(65, p.getTime(5));
    }

    @Test
    @Order(4)
    @DisplayName("* * * Testing example INPUT_test3.txt * * *")
    public void findPath3() {
        String file = "src/main/resources/INPUT_test3.txt";
        p = new PathTimeFinder(file);
        Assertions.assertThrows(IllegalArgumentException.class, () -> p.getTime(5));
    }
}
