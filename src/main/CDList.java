package main;

import org.w3c.dom.Node;

import java.util.NoSuchElementException;

public class CDList<E> {

    private DNode<E> head;
    private int size;

    /**
     * 자료구조 04 실습 과제를 참고하여 isEmpty(), insert(), delete()를 완성시키면 됩니다.
     * <br>필요하다면 생성자 또는 다른 메소드를 추가해도 됩니다.
     * <br>대신, PR 할 때 추가한 다른 함수에 대해서 어떤 역할을 가지고 있는지 작성해주세요.
     * <br>실습 과제와 달리 head를 dummy로 두지 않고 구현해야합니다.
     * <br>src/test/CDListTest 에서 테스트하거나 MainJava를 실행하여 임의의 입력을 하고 결과를 확인하면 됩니다.
     * <br>
     * <br>MainJava 입력은 다음과 같습니다.
     * <br>첫 번째 줄에 숫자들을 입력받아 순서대로 CDList의 맨 뒤에 넣습니다.
     * <br>두 번째 줄에 숫자들을 입력받아 delete(index)를 진행합니다.
     * <br>
     * <br>예제 입력
     * <br> 1 2 3 4 5
     * <br> 1 1
     * <br>
     * <br>예제 출력
     * <br>1 4 5
     */
    public CDList() {
    }

    public boolean isEmpty() {
        // TODO CDList가 비어있는지 여부를 반환하시오.
        if (size == 0) return true;
        else return false;
    }

    public void insert(int index, E newItem) {
        // TODO index가 올바르지 않을 때 IndexOutOfBoundsException 예외를 발생시키시오.
        if (index < 0 || size < index) throw new IndexOutOfBoundsException();

        // TODO head가 0번째 일 때 index번 째에 newItem 값을 삽입하도록 구현하시오.
        if (isEmpty()) {
            DNode<E> temp = new DNode<E>(newItem);
            head = temp;
            temp.setNext(temp);
            temp.setPrevious(temp);
            size++;
        } else {
            if (index == 0) {
                DNode<E> preNode = head.getPrevious();
                DNode<E> nextNode = head;
                DNode<E> nowNode = new DNode<E>(newItem);

                nowNode.setNext(nextNode);
                preNode.setNext(nowNode);
                nowNode.setPrevious(preNode);
                nextNode.setPrevious(nowNode);

                head = nowNode;
                size++;
            }else {
                DNode<E> preNode = head;
                int i = 1;
                while (index != i) {
                    preNode = preNode.getNext();
                    i++;
                }
                //지금 prenode는 index전 노드
                DNode<E> nextNode = preNode.getNext();
                DNode<E> nowNode = new DNode<E>(newItem);
                //앞 현재 뒤 노드 설정 완
                nowNode.setNext(nextNode);
                preNode.setNext(nowNode);
                nowNode.setPrevious(preNode);
                nextNode.setPrevious(nowNode);
                size++;
            }
        }
    }

    public E delete(int index) {
        // TODO 리스트가 비어있을 때 NoSuchElementException 예외를 발생시키시오.
        if (isEmpty()) throw new NoSuchElementException();
        // TODO index가 올바르지 않을 때 IndexOutOfBoundsException 예외를 발생시키시오.
        if (index < 0 || size <= index) throw new IndexOutOfBoundsException();


        // TODO head가 0번째 일 때 index번 째의 노드의 data를 반환하고 삭제하시오.
        DNode<E> temp;
        if (size == 1) {
            temp = head;
            head = null;
        } else {
            if (index == 0) {
                temp = head;
                DNode<E> preNode = head.getPrevious();
                DNode<E> nextNode = head.getNext();

                preNode.setNext(nextNode);
                nextNode.setPrevious(preNode);
                head = nextNode;
            }else {
                DNode<E> nowNode = head;
                int i = 0;
                while (index != i) {
                    nowNode = nowNode.getNext();
                    i++;
                }
                DNode<E> preNode = nowNode.getPrevious();
                DNode<E> nextNode = nowNode.getNext();

                preNode.setNext(nextNode);
                nextNode.setPrevious(preNode);
                temp = nowNode;
            }
        }
        size--;
        return temp.getData();
    }

    public String printall() {
        String[] res = new String[size];
        DNode<E> p = head;
        int i;
        for (i = 0; i < size/2; i++) {
            res[i] = p.getData().toString();
            p = p.getNext();
        }
        p = head;
        for (int j = 0; j < size - i; j++) {
            p = p.getPrevious();
            res[size - j - 1] = p.getData().toString();
        }
        return String.join(" ", res);
    }

    public void insertLast(E newItem) {
        insert(size, newItem);
    }

    public E deleteLast() {
        return delete(size - 1);
    }
}