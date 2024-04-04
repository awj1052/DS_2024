import main.CDList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CDListTest {

    @Test
    void example01() {
        //given
        CDList<Integer> list = new CDList<>();
        for (int i=0; i<5; i++) {
            list.insertLast(i);
        }

        //when
        boolean empty = list.isEmpty();

        //then
        assertThat(empty).isEqualTo(false);
    }

    @Test
    void example02() {
        //given
        CDList<Integer> list = new CDList<>();
        for (int i=0; i<5; i++) {
            list.insertLast(i);
        }
        list.insert(0, 99);

        //when
        String result = list.printall();

        //then
        assertThat(result).isEqualTo("99 0 1 2 3 4");
    }

    @Test
    void example03() {
        //given
        CDList<Person> list = new CDList<>();
        for (int i=0; i<26; i++) {
            String name = String.valueOf((char) ('A' + i));
            list.insertLast(new Person(name, i));
        }

        //when
        Person person = list.delete(5);

        //then
        assertThat(person).extracting(Person::name).isEqualTo("F");
    }

    @Test
    void example04() {
        //given
        CDList<Person> list = new CDList<>();
        for (int i=0; i<26; i++) {
            String name = String.valueOf((char) ('A' + i));
            list.insertLast(new Person(name, i));
        }
        for (int i=0; i<26; i++) {
            list.deleteLast();
        }

        //when
        Throwable thrown = catchThrowable(list::deleteLast);

        //then
        assertThat(thrown).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void example05() {
        //given
        CDList<String> list = new CDList<>();
        list.insertLast("apple");
        list.insertLast("banana");
        list.insert(0, "cherry");
        list.insert(1, "orange");

        //when
        String result = list.printall();

        //then
        assertThat(result).isEqualTo("cherry orange apple banana");
    }

    @Test
    void example06() {
        //given
        CDList<Character> list = new CDList<>();

        //when
        Throwable thrown = catchThrowable(()->{
           list.insert(1, 'a');
        });

        //then
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void example07() {
        //given
        CDList<Float> list = new CDList<>();
        list.insert(0, 1.23f);

        //when
        Throwable thrown = catchThrowable(()->{
           list.delete(1);
        });

        //then
        assertThat(thrown).isInstanceOf(IndexOutOfBoundsException.class);
    }
}

record Person(String name, int age) {
    @Override
    public String toString() {
        return name + " " + age;
    }
}