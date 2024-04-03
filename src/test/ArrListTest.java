import main.ArrList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class ArrListTest {

    @Test
    void example01() {
        //given
        ArrList<Integer> list = new ArrList<>();
        for(int i=0; i<10; i++) list.insertLast(0);
        for(int i=0; i<3; i++) list.deleteLast();

        //when
        int size = list.getSize();

        //then
        assertThat(size).isEqualTo(7);
    }

    @Test
    void example02() {
        //given
        ArrList<Integer> list = new ArrList<>();
        for(int i=0; i<10; i++) list.insertLast(0);
        for(int i=0; i<3; i++) list.deleteLast();

        //when
        String print = list.printall();

        //then
        assertThat(print).isEqualTo("0 0 0 0 0 0 0 ");
    }

    @Test
    void example03() {
        //given
        ArrList<Person> people = new ArrList<>();
        for (int i = 0; i < 26; i++) {
            final String name = String.valueOf((char) (i+'A'));
            people.insertLast(new Person(name, i));
        }
        for (int i = 0; i < 10; i++) {
            people.delete(0);
        }

        //when
        Person person = people.delete(0);

        //then
        assertThat(person).extracting(Person::name).isEqualTo("K");
    }

    @Test
    void example04() {
        //given
        ArrList<Person> people = new ArrList<>();
        for (int i = 0; i < 26; i++) {
            final String name = String.valueOf((char) (i+'A'));
            people.insertLast(new Person(name, i));
        }
        for (int i = 0; i < 26; i++) {
            people.deleteLast();
        }

        //when
        Throwable thrown = catchThrowable(()-> {
           Person person = people.deleteLast();
        });

        //then
        assertThat(thrown).isInstanceOf(NoSuchElementException.class);
    }
}
