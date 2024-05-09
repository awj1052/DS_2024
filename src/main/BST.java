package main;

public class BST<Key extends Comparable<Key>, Value> extends Tree<Key, Value> {

    /**
     * 일반적으로 BST는 중위순회를 하면 Key가 오름차순으로 출력됩니다.
     * <br/>그렇게 하면 재미가 없으니 중위순회를 하면 Key가 "내림차순"이 되도록 해봅시다.
     */
    public BST(Node<Key, Value> root) {
        super(root);
    }

    @Override
    public void put(Key key, Value value) {
        super.setRoot(put(super.getRoot(), key, value));
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        // TODO 해당 메소드를 완성하시오.
        return null;
    }

    @Override
    public void delete(Key key) {
        super.setRoot(delete(super.getRoot(), key));
    }

    public Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        // TODO 해당 메소드를 완성하시오.
        // TODO 강의 자료와 다르게 max와 deleteMax를 사용합시다.
        return null;
    }

    private Key max() {
        if (super.getRoot() == null) return null;
        return max(super.getRoot()).getKey();
    }

    /**
     * 강의 자료는 min을 찾지만 이번엔 max를 찾아봅시다.
     * 요구하는 BST의 중위순회의 Key 값이 내림차순임에 주의하세요.
     * @param node
     * @return Key가 큰 노드
     */
    private Node<Key, Value> max(Node<Key, Value> node) {
        // TODO 해당 메소드를 완성하시오.
        return null;
    }

    private void deleteMax() {
        if (super.getRoot() == null) return;
        super.setRoot(deleteMax(super.getRoot()));
    }

    /**
     * 강의 자료는 deleteMin이지만 이번엔 deleteMax를 해봅시다.
     * 요구하는 BST의 중위순회의 Key 값이 내림차순임에 주의하세요.
     * @param node
     * @return node
     */
    private Node<Key, Value> deleteMax(Node<Key, Value> node) {
        // TODO 해당 메소드를 완성하시오.
        return null;
    }

    @Override
    public Tree<Key, Value> copy() {
        return new BST<>(copy(super.getRoot()));
    }

    /**
     * this에 대해서 루트를 포함한 모든 자식 노드들의 레퍼런스가 다르지만,
     * <br/>Key와 Value가 동일한 새로운 BST를 만들려고 합니다.
     * @param my 카피할 노드를 인자로 받습니다.
     * @return 카피된 노드를 반환합니다.
     * @see BST#delete
     */
    private Node<Key, Value> copy(Node<Key, Value> my) {
        // TODO 해당 메소드를 완성하시오.
        return null;
    }

    @Override
    public Value get(Key key) {
        return get(super.getRoot(), key);
    }

    private Value get(Node<Key, Value> node, Key key) {
        // TODO 해당 메소드를 완성하시오.
        // TODO key가 존재하지 않는다면 null을 반환하시오.
        return null;
    }
}