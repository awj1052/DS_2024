import main.BST;
import main.BSTTraversal;
import main.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BSTTest {

    private BST<Integer, String> bst;

    @BeforeEach
    void setup() {
        int numberOfAll = 26+1;
        List<Node<Integer, String>> list = new ArrayList<>();
        for (int i=0; i<numberOfAll-1; i++) {
            list.add(new Node<>(i, ((char) (i+'a'))+""));
        }
        list.add(new Node<>(99, "zz"));
        bst = new BST<>(list.get(13));
        for(int i=0; i<numberOfAll; i++) {
            Node<Integer, String> node = list.get(i);
            bst.put(node.getKey(), node.getValue());
        }
    }

    @Test
    void getTest() {
        //given

        //when
        String value = bst.get(3);

        //then
        assertThat(value).isEqualTo("d");
    }

    @Test
    void getTest2() {
        //given

        //when
        String res = bst.get(55);

        //then
        assertThat(res).isEqualTo(null);
    }

    @Test
    void deleteTest() {
        //given
        BSTTraversal<Integer, String> bstTraversal = new BSTTraversal<>(bst);

        //when
        for (int i=10; i<20; i++) {
            bst.delete(i);
        }
        List<String> res = bstTraversal.inOrder();

        //then
        String[] ans = {"zz", "z", "y", "x", "w", "v", "u", "j", "i", "h", "g", "f", "e", "d", "c" ,"b" ,"a"};
        assertThat(ans.length).isEqualTo(res.size());
        for (int i=0; i<ans.length; i++) {
            assertThat(ans[i]).isEqualTo(res.get(i));
        }
    }

    @Test
    void copyTest() {
        //given
        BST<Integer, String> copied = (BST<Integer, String>) bst.copy();

        //when

        //then

        Queue<Pair<Node<Integer, String>, Node<Integer, String>>> q = new ArrayDeque<>();
        q.add(new Pair<>(bst.getRoot(), copied.getRoot()));
        while (!q.isEmpty()){
            var p = q.poll();
            assertThat(p.orig).isNotSameAs(p.copied);
            var origLeft = p.orig.getLeft();
            var copiedLeft = p.copied.getLeft();
            var origRight = p.orig.getRight();
            var copiedRight = p.copied.getRight();
            if (origLeft != null && copiedLeft != null)
                q.add(new Pair<>(origLeft, copiedLeft));
            if (origRight != null && copiedRight != null)
                q.add(new Pair<>(origRight, copiedRight));
            assertThat((origLeft != null && copiedLeft == null) || (origLeft == null && copiedLeft != null)).isEqualTo(false);
            assertThat((origRight != null && copiedRight == null) || (origRight == null && copiedRight != null)).isEqualTo(false);
        }
    }

    private record Pair<T, K>(T orig, K copied){
    }
}
