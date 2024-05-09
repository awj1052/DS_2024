package main;

public abstract class Tree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

    public Tree(Node<Key, Value> root) {
        this.root = root;
    }

    public final Node<Key, Value> getRoot() {
        return root;
    }

    public final void setRoot(Node<Key, Value> root) {
        this.root = root;
    }

    public abstract Tree<Key, Value> copy();
    public abstract void put(Key key, Value value);
    public abstract void delete(Key key);
    public abstract Value get(Key key);
}
