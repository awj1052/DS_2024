import main.PostNotation;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PostNotationTest {

    void TestPostNotation(String infixNotation, int[] number, int answer){
        //given
        String notation = PostNotation.convert(infixNotation);
        PostNotation postNotation = new PostNotation(notation, number);

        //when
        int value = postNotation.calcValue();

        //then
        assertThat(value).isEqualTo(answer);
    }

    @Test
    void example01() {
        TestPostNotation("C*(A+B)", new int[]{2, 3, 4}, 20);
    }

    @Test
    void example02() {
        TestPostNotation("C/(B-A)*(D+E)", new int[]{1, 3, 4, 3, 5}, 16);
    }

    @Test
    void example03() {
        TestPostNotation("(A+B)/(C-D)", new int[]{1, 4, 5, 3}, 2);
    }

    @Test
    void example04() {
        TestPostNotation("(A*(B+C)+D)/E", new int[]{2, 3, 4, 6, 6}, 3);
    }

    @Test
    void example05() {
        TestPostNotation("(D+A*(B+C))/E", new int[]{2, 3, 4, 6, 6}, 3);
    }


    @Test
    void example06() {
        TestPostNotation("(D+(B+C)*A)/E", new int[]{2, 3, 4, 6, 6}, 3);
    }

    @Test
    void example07() {
        TestPostNotation("A*((B*C)*D)*E", new int[]{13, 7, 99, 41, 37}, 13666653);
    }
}
