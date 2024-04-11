package main;

public class LCA {

    private final BinaryTree<Integer> binaryTree;

    public LCA(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    public int getLCA(int a, int b) {
        return getLCA(a, b, binaryTree.getRoot());
    }

    /**
     * {@link BinaryTree} 의 최소 공통 조상(Lowest Common Ancestor, LCA)를 구하는 문제입니다.
     * <br>최소 공통 조상은 트리 구조에서 임의의 두 정점이 갖는 가장 가까운 조상 정점을 의미합니다.
     * <br>예를 들어, 1이 루트, 2가 왼쪽 자식, 3이 오른쪽 자식이면  2,3의 LCA는 1이 됩니다.
     * <br>1이 루트, 2가 왼쪽, 3이 오른쪽, 5가 2의 오른쪽, 6이 3의 왼쪽일 때 5,3의 LCA과 6,2의 LCA는 다 1입니다.
     * <br>LCA를 구하는 알고리즘을 재귀적으로 작성하면 됩니다.
     * <br>이번에는 MainJava와 InputManager 없이 Test 파일로만 테스트가 가능합니다.
     *
     * @see BinaryTreeTravel#postOrder()
     *
     * @return a와 b의 LCA의 item을 반환합니다.
     *
     */
    private int getLCA(int a, int b, Node<Integer> node) {
        // TODO item이 a와 b인 Node들의 최소 공통 조상 LCA의 item을 반환하는 코드를 작성하시오.
        return 0;
    }
}
