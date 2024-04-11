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
        return 1;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<Key> node) {
        if (node == null) return 0;
        // TODO 반환값을 올바르게 작성하시오.
        return 1;
    }

    public boolean isEqual(BinaryTree<Key> other) {
        return isEqual(root, other.getRoot());
    }

    private boolean isEqual(Node<Key> node1, Node<Key> node2) {
        if (node1 == null || node2 == null) return node1 == node2;
        if (node1.getItem().compareTo(node2.getItem()) != 0) return false;
        // TODO 반환값을 올바르게 작성하시오.
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<Key> getRoot() {
        return root;
    }
}
