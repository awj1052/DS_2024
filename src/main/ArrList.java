package main;

import java.util.NoSuchElementException;

public class ArrList<E> {

    private E a[];

    private int size;

    public ArrList() {
        a = (E[]) new Object[1];
        size = 0;
    }

    /**
     * {@link ArrList} 의 resize를 제외한 모든 메소드는 올바르게 동작합니다.
     * <br>a, size를 활용하여 resize 메소드를 완성하면 됩니다.
     * <br>MainJava를 실행하여 예제를 입력했을 때 올바르게 결과가 나오거나,
     * <br>src/test/ArrListTest 에서 테스트를 진행하면 됩니다.
     * <br>JUnit 관련하여 찾아보는 것을 추천합니다.
     * <br> + resize만 완성하면 되기때문에 MainJava, InputManager을 굳이 알 필요는 없습니다.
     * 콘솔에서 실행했을 때 확인하는 용도일 뿐 ArrListTest에서 모든 테스트를 통과하면 됩니다.
     * <br>
     * <br>예제 입력
     * <br>5
     * <br>1 2 3 4 5
     * <br>2
     * <br>
     * <br>예제 출력
     * <br>1 2 3
     */
    private void resize(int newSize) {
        // TODO resize 함수를 완성하시오.
        var newArr = new Object[newSize];
        int len = Math.min(newSize, size);
        for (int i = 0; i < len; i++){
            newArr[i] = a[i];
        }
        a = (E[])newArr;
    }

    public E deleteLast() {
        return delete(size-1);
    }

    public E delete(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = a[index];
        for (int i=index; i<size; i++) {
            a[i] = a[i+1];
        }
        size--;
        if (size > 0 && size == a.length/4) {
            resize(a.length/2);
        }
        return item;
    }

    public void insertLast(E newItem) {
        insert(newItem, size);
    }

    public void insert(E newItem, int index) {
        if (size == a.length) {
            resize(2*a.length);
        }
        for (int i=size-1; i>=index; i++) a[i+1] = a[i];
        a[index] = newItem;
        size++;
    }

    public E peek(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return a[index];
    }

    public String printall() {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<size; i++) {
            res.append(peek(i)).append(" ");
        }
        return res.toString();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
