import main.BinaryTree;
import main.Node;
import main.LCA;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LCATest {

    private static Node<Integer>[] arr;

    @BeforeAll
    static void setUp() {
        arr = new Node[16];
        for (int i=0; i<16; i++) {
            arr[i] = new Node<>(i, null, null);
        }

        for(int i=0; i<4; i++) {
            arr[i].setLeft(arr[i+1]);
        }
        arr[3].setRight(arr[15]);
        arr[4].setRight(arr[14]);
        arr[2].setRight(arr[13]);
        arr[13].setRight(arr[12]);
        arr[13].setLeft(arr[11]);
        arr[4].setLeft(arr[8]);
        arr[14].setLeft(arr[5]);
        arr[14].setRight(arr[6]);
        arr[0].setRight(arr[10]);
        arr[10].setLeft(arr[9]);
        arr[10].setRight(arr[7]);
    }

    @Test
    void example01() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[10]);
        LCA lca = new LCA(binaryTree);

        //when
        int ans = lca.getLCA(9, 7);

        //then
        assertThat(ans).isEqualTo(10);
    }

    @Test
    void example02() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);
        LCA lca = new LCA(binaryTree);

        //when
        int ans = lca.getLCA(11, 8);

        //then
        assertThat(ans).isEqualTo(2);
    }

    @Test
    void example03() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);
        LCA lca = new LCA(binaryTree);

        //when
        int ans = lca.getLCA(5, 9);

        //then
        assertThat(ans).isEqualTo(0);
    }

    @Test
    void example04() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);
        LCA lca = new LCA(binaryTree);

        //when
        int ans = lca.getLCA(3, 5);

        //then
        assertThat(ans).isEqualTo(3);
    }

    @Test
    void example05() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);
        LCA lca = new LCA(binaryTree);

        //when
        int ans = lca.getLCA(11, 8);

        //then
        assertThat(ans).isEqualTo(2);
    }

    @Test
    void example06() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);
        LCA lca = new LCA(binaryTree);

        //when
        int ans = lca.getLCA(6, 8);

        //then
        assertThat(ans).isEqualTo(4);
    }


    @Test
    void example07() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);
        LCA lca = new LCA(binaryTree);

        //when
        int ans = lca.getLCA(1, 1);

        //then
        assertThat(ans).isEqualTo(1);
    }
}
