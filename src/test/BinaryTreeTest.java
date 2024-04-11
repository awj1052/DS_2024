import main.BinaryTree;
import main.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTest {

    private Node<Integer>[] arr;

    @BeforeEach
    void setUp() {
        arr = new Node[16];
        for (int i=0; i<16; i++) {
            arr[i] = new Node<>(i, null, null);
        }
    }

    @Test
    @DisplayName("간단한 BinaryTree의 size 확인")
    void example01() {
        //given
        arr[0].setLeft(arr[1]);
        arr[0].setRight(arr[2]);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);

        //when
        int size = binaryTree.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @Test
    @DisplayName("복잡한 BinaryTree의 size 확인")
    void example02() {
        //given
        for(int i=0; i<8; i++) {
            arr[i].setLeft(arr[i+1]);
        }
        arr[3].setRight(arr[15]);
        arr[4].setRight(arr[14]);
        arr[2].setRight(arr[13]);
        arr[13].setRight(arr[12]);
        arr[13].setLeft(arr[11]);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);

        //when
        int size = binaryTree.size();

        //then
        assertThat(size).isEqualTo(14);
    }

    @Test
    @DisplayName("복잡한 BinaryTree의 height 확인")
    void example03() {
        //given
        for(int i=0; i<8; i++) {
            arr[i].setLeft(arr[i+1]);
        }
        arr[3].setRight(arr[15]);
        arr[4].setRight(arr[14]);
        arr[2].setRight(arr[13]);
        arr[13].setRight(arr[12]);
        arr[13].setLeft(arr[11]);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);

        //when
        int height = binaryTree.height();

        //then
        assertThat(height).isEqualTo(9);
    }
}
