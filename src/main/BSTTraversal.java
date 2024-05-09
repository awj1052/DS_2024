package main;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal<Key extends Comparable<Key>, Value> {

    private final BST<Key, Value> bst;

    public BSTTraversal(BST<Key, Value> bst) {
        this.bst = bst;
    }

    public List<Value> inOrder() {
        List<Value> list = new ArrayList<>();
        inOrder(bst.getRoot(), list);
        return list;
    }

    private void inOrder(Node<Key, Value> node, List<Value> list) {
        if (node == null) return;
        inOrder(node.getLeft(), list);
        list.add(node.getValue());
        inOrder(node.getRight(), list);
    }
}
