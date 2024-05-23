import main.Person;
import main.VIPQueue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class VIPQueueTest {

    @Test
    void example01() {
        //given
        final int SIZE = 10;
        Person[] people = new Person[SIZE];
        for (int i=0; i<SIZE; i++) {
            people[i] = new Person((char)(i+'A') + "", i, i);
        }
        VIPQueue vipQueue = new VIPQueue(people);

        //when
        ArrayList<Person> res = new ArrayList<>();
        for (int i=0; i<5; i++) {
            res.add(vipQueue.pop());
        }

        //then
        ArrayList<String> ans = new ArrayList<>() {{
            add("J 9");
            add("I 8");
            add("H 7");
            add("G 6");
            add("F 5");
        }};
        for (int i=0; i<ans.size(); i++) {
            assertThat(res.get(i).toString()).isEqualTo(ans.get(i));
        }
    }

    @Test
    void example02() {
        //given
        Person[] people = new Person[20];
        for (int i=0; i<9; i++) {
            int random = (int) (Math.random() * 100);
            people[i] = new Person((char) (random%26 + 'a') + "", random, random);
        }
        people[9] = new Person("AAA", 10, 1000);
        people[10] = new Person("BBB", 20, 999);
        for (int i=11; i<20; i++) {
            int random = (int) (Math.random() * 100);
            people[i] = new Person((char) (random%26 + 'a') + "", random, random);
        }
        VIPQueue vipQueue = new VIPQueue(people);

        //when
        ArrayList<Person> res = new ArrayList<>();
        for (int i=0; i<2; i++) {
            res.add(vipQueue.pop());
        }

        //then
        ArrayList<String> ans = new ArrayList<>() {{
            add("AAA 10");
            add("BBB 20");
        }};
        for (int i=0; i<ans.size(); i++) {
            assertThat(res.get(i).toString()).isEqualTo(ans.get(i));
        }
    }
}
