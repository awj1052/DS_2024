import main.PostNotation;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PostNotationTest {

    @Test
    void example01() {
        //given
        int N = 3;
        String notation = PostNotation.convert("C*(A+B)");
        int[] number = {2, 3, 4};
        PostNotation postNotation = new PostNotation(N, notation, number);

        //when
        int value = postNotation.calcValue();

        //then
        assertThat(value).isEqualTo(20);
    }

    @Test
    void example02() {
        //given
        int N = 5;
        String notation = PostNotation.convert("C/(B-A)*(D+E)");
        int[] number = {1, 3, 4, 3, 5};
        PostNotation postNotation = new PostNotation(N, notation, number);

        //when
        int value = postNotation.calcValue();

        //then
        assertThat(value).isEqualTo(16);
    }

    @Test
    void example03() {
        //given
        int N = 4;
        String notation = PostNotation.convert("(A+B)/(C-D)");
        int[] number = {1, 4, 5, 3};
        PostNotation postNotation = new PostNotation(N, notation, number);

        //when
        int value = postNotation.calcValue();

        //then
        assertThat(value).isEqualTo(2);
    }

    @Test
    void example04() {
        //given
        int N = 3;
        String notation = PostNotation.convert("(A*(B+C)+D)/E");
        int[] number = {2, 3, 4, 6, 6};
        PostNotation postNotation = new PostNotation(N, notation, number);

        //when
        int value = postNotation.calcValue();

        //then
        assertThat(value).isEqualTo(3);
    }

    @Test
    void example05() {
        //given
        int N = 3;
        String notation = PostNotation.convert("(D+A*(B+C))/E");
        int[] number = {2, 3, 4, 6, 6};
        PostNotation postNotation = new PostNotation(N, notation, number);

        //when
        int value = postNotation.calcValue();

        //then
        assertThat(value).isEqualTo(3);
    }


    @Test
    void example06() {
        //given
        int N = 3;
        String notation = PostNotation.convert("(D+(B+C)*A)/E");
        int[] number = {2, 3, 4, 6, 6};
        PostNotation postNotation = new PostNotation(N, notation, number);

        //when
        int value = postNotation.calcValue();

        //then
        assertThat(value).isEqualTo(3);
    }
}
