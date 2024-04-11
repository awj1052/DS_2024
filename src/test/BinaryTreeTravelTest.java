
import main.BinaryTree;
import main.BinaryTreeTravel;
import main.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTravelTest {

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
    @DisplayName("inOrder 테스트")
    void example01() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);
        BinaryTreeTravel<Integer> binaryTreeTravel = new BinaryTreeTravel<>(binaryTree);

        //when
        List<Integer> list = binaryTreeTravel.inOrder();

        //then
        int[] ans = {8, 4, 5, 14, 6, 3, 15, 2, 11, 13, 12, 1, 0, 9, 10, 7};
        for (int i=0; i<ans.length; i++) {
            assertThat(list.get(i)).isEqualTo(ans[i]);
        }
    }

    @Test
    @DisplayName("postOrder 테스트")
    void example02() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);
        BinaryTreeTravel<Integer> binaryTreeTravel = new BinaryTreeTravel<>(binaryTree);

        //when
        List<Integer> list = binaryTreeTravel.postOrder();

        //then
        int[] ans = {8, 5, 6, 14, 4, 15, 3, 11, 12, 13, 2, 1, 9, 7, 10, 0};
        for (int i=0; i<ans.length; i++) {
            assertThat(list.get(i)).isEqualTo(ans[i]);
        }
    }

    @Test
    @DisplayName("levelOrder 테스트")
    void example03() {
        //given
        BinaryTree<Integer> binaryTree = new BinaryTree<>(arr[0]);
        BinaryTreeTravel<Integer> binaryTreeTravel = new BinaryTreeTravel<>(binaryTree);

        //when
        List<Integer> list = binaryTreeTravel.levelOrder();

        //then
        int[] ans = {0, 1, 10, 2, 9, 7, 3, 13, 4, 15, 11, 12, 8, 14, 5, 6};
        for (int i=0; i<ans.length; i++) {
            assertThat(list.get(i)).isEqualTo(ans[i]);
        }
    }
}
