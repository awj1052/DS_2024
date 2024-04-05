import main.Josephus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JosephusTest {

    @Test
    void example01() {
        //given
        Josephus josephus = new Josephus(7, 3);

        //when
        int[] res = josephus.solve();

        //then
        int[] ans = {3, 6, 2, 7, 5, 1, 4};
        for (int i=0; i<ans.length; i++) {
            assertThat(res[i]).isEqualTo(ans[i]);
        }
    }

    @Test
    void example02() {
        //given
        Josephus josephus = new Josephus(13, 5);

        //when
        int[] res = josephus.solve();

        //then
        int[] ans = {5, 10, 2, 8, 1, 9, 4, 13, 12, 3, 7, 11, 6};
        for (int i=0; i<ans.length; i++) {
            assertThat(res[i]).isEqualTo(ans[i]);
        }
    }
}
