package task1;

import org.junit.jupiter.api.*;

public class SimplifyingEnglishTextTest {

    private SimplifyingEnglishText s;

    @BeforeEach
    public void before() {
        s = new SimplifyingEnglishText();
    }

    @Test
    @DisplayName("* * * Testing .simplify() method * * *")
    public void shouldSimplify() {
        Assertions.assertEquals("kakao and kofi", s.simplify("cacao and coffee"));
        Assertions.assertEquals("sukses", s.simplify("success"));

        String testText = "A unicorn knows more theories about the universe than a smartest guy can ever imagine";
        String outText = "unikorn knows mor theories about univers than smartest guy kan ever imagin";
        Assertions.assertEquals(outText, s.simplify(testText));
    }

    @Test
    @DisplayName("* * * Testing .removeCLetter() method * * *")
    public void shouldRemoveC() {
        Assertions.assertEquals("suksess", s.removeC("success"));

        Assertions.assertEquals("luk", s.removeC("luck"));
        Assertions.assertEquals("sentral", s.removeC("central"));
        Assertions.assertEquals("sinnamon", s.removeC("cinnamon"));
    }

    @Test
    @DisplayName("* * * Testing .removeDoubleChar() method * * *")
    public void shouldRemoveDoubleChar() {
        Assertions.assertEquals("uo", s.removeDoubleChar("ooo"));
        Assertions.assertEquals("u", s.removeDoubleChar("oou"));
        Assertions.assertEquals("i", s.removeDoubleChar("iee"));

        Assertions.assertEquals("ups i spiled cofi on her dres", s.removeDoubleChar(
                "Oops i spilled coffee on her dress"));
    }

    @Test
    @DisplayName("* * * Testing .removeLastE() method * * *")
    public void shouldRemoveLastE() {
        Assertions.assertEquals("Th", s.removeLastE("The"));

        String testText = "The more he learns - the more he knows. Dance, Eagle e, dance";
        String outText = "Th mor h learns - th mor h knows. Danc, Eagl e, danc";
        Assertions.assertEquals(outText, s.removeLastE(testText));
    }

    @Test
    @DisplayName("* * * Testing .removeArticle() method * * *")
    public void shouldRemoveArticle() {
        Assertions.assertEquals("table", s.removeArticle("the table"));

        String text = "A unicorn knows more theories about the universe than a smartest guy can ever imagine.";
        String outText = "unicorn knows more theories about universe than smartest guy can ever imagine.";
        Assertions.assertEquals(outText, s.removeArticle(text));
    }
}
