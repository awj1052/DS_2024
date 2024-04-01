import main.MainJava;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PostNotationTest {

    @Test
    void example01() {
        //given
        int N = 3;
        String infixNotation = "C*(A+B)";
        int[] number = {2, 3, 4};
        MainJava mainJava = new MainJava(N, infixNotation, number);

        //when
        int value = mainJava.getResult();

        //then
        assertThat(value).isEqualTo(20);
    }

    @Test
    void example02() {
        //given
        int N = 5;
        String infixNotation = "C/(B-A)*(D+E)";
        int[] number = {1, 3, 4, 3, 5};
        MainJava mainJava = new MainJava(N, infixNotation, number);

        //when
        int value = mainJava.getResult();

        //then
        assertThat(value).isEqualTo(16);
    }

    @Test
    void example03() {
        //given
        int N = 4;
        String infixNotation = "(A+B)/(C-D)";
        int[] number = {1, 4, 5, 3};
        MainJava mainJava = new MainJava(N, infixNotation, number);

        //when
        int value = mainJava.getResult();

        //then
        assertThat(value).isEqualTo(2);
    }

    @Test
    void example04() {
        //given
        int N = 3;
        String infixNotation = "(A*(B+C)+D)/E";
        int[] number = {2, 3, 4, 6, 6};
        MainJava mainJava = new MainJava(N, infixNotation, number);

        //when
        int value = mainJava.getResult();

        //then
        assertThat(value).isEqualTo(3);
    }

    @Test
    void example05() {
        //given
        int N = 3;
        String infixNotation = "(D+A*(B+C))/E";
        int[] number = {2, 3, 4, 6, 6};
        MainJava mainJava = new MainJava(N, infixNotation, number);

        //when
        int value = mainJava.getResult();

        //then
        assertThat(value).isEqualTo(3);
    }


    @Test
    void example06() {
        //given
        int N = 3;
        String infixNotation = "(D+(B+C)*A)/E";
        int[] number = {2, 3, 4, 6, 6};
        MainJava mainJava = new MainJava(N, infixNotation, number);

        //when
        int value = mainJava.getResult();

        //then
        assertThat(value).isEqualTo(3);
    }
}
