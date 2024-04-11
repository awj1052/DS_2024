package main;

public class BinaryTree<Key extends Comparable<Key>> {

    private final Node<Key> root;

    public BinaryTree(Node<Key> root) {
        this.root = root;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<Key> node) {
        if (node == null) return 0;
        // TODO 반환값을 올바르게 작성하시오.
        var left = node.getLeft();
        var right = node.getRight();
        if (left == null && right == null)
            return 1;
        return size(node.getLeft()) + size(node.getRight()) + 1;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<Key> node) {
        if (node == null) return 0;
        // TODO 반환값을 올바르게 작성하시오.
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }

    public boolean isEqual(BinaryTree<Key> other) {
        return isEqual(root, other.getRoot());
    }

    private boolean isEqual(Node<Key> node1, Node<Key> node2) {
        if (node1 == null || node2 == null) return node1 == node2;
        if (node1.getItem().compareTo(node2.getItem()) != 0) return false;
        var left1 = node1.getLeft();
        var right1 = node1.getRight();
        var left2 = node2.getLeft();
        var right2 = node2.getRight();
        return isEqual(left1, left2) && isEqual(right1, right2);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<Key> getRoot() {
        return root;
    }
}
