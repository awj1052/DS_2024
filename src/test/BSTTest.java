import main.BST;
import main.BSTTraversal;
import main.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        assertThat(copied.getRoot()).isNotEqualTo(bst.getRoot());
        assertThat(copied.getRoot().getValue()).isEqualTo(bst.getRoot().getValue());
    }
}
