import main.ArrayQueue;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ArrayQueueTest {

    @Test
    void example01() {
        //given
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i=0; i<5; i++) {
            queue.add(i);
        }
        queue.remove();

        //when
        int value = queue.element();

        //then
        assertThat(value).isEqualTo(1);
    }

    @Test
    void example02() {
        //given
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i=0; i<5; i++) {
            queue.add(i);
        }
        for (int i=0; i<5; i++) {
            queue.remove();
        }

        //when
        Throwable thrown = catchThrowable(queue::remove);

        //then
        assertThat(thrown).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void example03() {
        //given
        ArrayQueue<Character> queue = new ArrayQueue<>();
        for (int i=0; i<26; i++) {
            queue.add(((char) ('A' + i)));
        }
        for (int i=0; i<10; i++) {
            queue.remove();
        }

        //when
        char value = queue.remove();

        //then
        assertThat(value).isEqualTo('K');
    }

    @Test
    void example04() {
        //given
        ArrayQueue<Boolean> queue = new ArrayQueue<>();

        //when
        Throwable thrown = catchThrowable(()->{
            queue.add(null);
        });

        //then
        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }
}
