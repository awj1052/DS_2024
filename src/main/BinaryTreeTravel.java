package main;

import java.util.*;

public class BinaryTreeTravel<Key extends Comparable<Key>> {

    private final BinaryTree<Key> binaryTree;

    public BinaryTreeTravel(BinaryTree<Key> binaryTree) {
        this.binaryTree = binaryTree;
    }

    public List<Key> preOrder() {
        List<Key> list = new ArrayList<>();
        preOrder(binaryTree.getRoot(), list);
        return list;
    }

    private void preOrder(Node<Key> node, List<Key> list) {
        if (node == null) return;
        list.add(node.getItem());
        preOrder(node.getLeft(), list);
        preOrder(node.getRight(), list);
    }

    public List<Key> inOrder() {
        List<Key> list = new ArrayList<>();
        inOrder(binaryTree.getRoot(), list);
        return list;
    }

    private void inOrder(Node<Key> node, List<Key> list) {
        // TODO preOrder를 참고하여 해당 메소드를 완성시키시오.
        if (node == null) return;
        inOrder(node.getLeft(), list);
        list.add(node.getItem());
        inOrder(node.getRight(), list);
    }

    public List<Key> postOrder() {
        List<Key> list = new ArrayList<>();
        postOrder(binaryTree.getRoot(), list);
        return list;
    }

    private void postOrder(Node<Key> node, List<Key> list) {
        // TODO preOrder를 참고하여 해당 메소드를 완성시키시오.
        if (node == null) return;
        postOrder(node.getLeft(), list);
        postOrder(node.getRight(), list);
        list.add(node.getItem());
    }

    public List<Key> levelOrder() {
        List<Key> list = new ArrayList<>();
        levelOrder(binaryTree.getRoot(), list);
        return list;
    }

    private void levelOrder(Node<Key> node, List<Key> list) {
        // TODO java.util.Queue 와 자료구조 PDF를 참고하여 해당 메소드를 완성시키시오.
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            list.add((Key) temp.getItem());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }
}
