package main;

public class CDList<E> {

    private DNode<E> head;
    private int size;

    /**
     * 자료구조 04 실습 과제를 참고하여 isEmpty(), insert(), delete()를 완성시키면 됩니다.
     * <br>필요하다면 생성자 또는 다른 메소드를 추가해도 됩니다.
     * <br>대신, PR 할 때 추가한 다른 함수에 대해서 어떤 역할을 가지고 있는지 작성해주세요.
     * <br>실습 과제와 달리 head를 dummy로 두지 않고 구현해야합니다.
     */
    public CDList() {
    }

    public boolean isEmpty() {
        // TODO CDList가 비어있는지 여부를 반환하시오.
        return false;
    }

    public void insert(int index, E newItem) {
        // TODO head가 0번째 일 때 index번 째에 newItem 값을 삽입하도록 구현하시오.
        // TODO index가 올바르지 않을 때 IndexOutOfBoundsException 예외를 발생시키시오.
    }

    public E delete(int index) {
        // TODO head가 0번째 일 때 index번 째의 노드의 data를 반환하고 삭제하시오.
        // TODO 리스트가 비어있을 때 NoSuchElementException 예외를 발생시키시오.
        // TODO index가 올바르지 않을 때 IndexOutOfBoundsException 예외를 발생시키시오.
        return null;
    }

    public String printall() {
        StringBuilder res = new StringBuilder();
        DNode<E> p = head;
        for (int i = 0; i < size; i++) {
            res.append(p.getData()).append(" ");
            p = p.getNext();
        }
        return res.toString();
    }

    public void insertLast(E newItem) {
        insert(size, newItem);
    }

    public E deleteLast() {
        return delete(size - 1);
    }
}