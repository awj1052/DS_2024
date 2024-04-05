package main;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {

    private E[] queue;
    private int front, rear, size;

    /**
     * 자료구조 배포 PDF의 ArrayQueue 구현 문제입니다.
     * 배열의 front는 항상 맨 처음 원소의 이전 index를 가르키고 rear는 마지막 원소의 index를 가르키도록 구현하세요.
     * ArrayQueue 구현이 어렵지 않아 큐 활용 문제인 요세푸스 문제 요구사항 또한 완성하면 됩니다.
     * PR 날릴 때 작성한 코드에 대한 1줄 요약도 작성해주세요.
     */
    public ArrayQueue() {
        queue = (E[]) new Object[2];
        front = rear = size = 0;
    }

    public E element() {
        // TODO 큐의 맨 앞의 원소를 반환하는 코드를 작성하시오
        // TODO 큐가 비어있다면 NoSuchElementException 예외를 발생시키시오
        if (isEmpty())
            throw new NoSuchElementException();
        return queue[after(front, 1)];
    }

    public void add(E item) {
        // TODO 큐에 item을 추가하는 코드를 작성하시오
        // TODO item이 null이라면 NullPointerException 예외를 발생시키시오
        // TODO 큐가 꽉 차있으면 길이를 resize()를 활용하여 2배로 늘리시오
        if (item == null)
            throw new NullPointerException();
        if (after(rear, 1) == front){
            resize(queue.length << 1);
        }
        rear = after(rear, 1);
        queue[rear] = item;
        size++;
    }

    private void resize(int newSize) {
        // TODO resize를 완성시키시오
        var newArr = (E[]) new Object[newSize];
        for (int i = 0; i < size + 1; i++){
            newArr[i] = queue[after(front, i)];
        }
        queue = newArr;
        rear = size;
        front = 0;
    }

    public E remove() {
        // TODO 큐에서 item을 반환하고 삭제하는 코드를 작성하시오
        // TODO 큐가 비어있다면 NoSuchElementException 예외를 발생시키시오
        // TODO 큐가 배열의 1/4만 사용하고 있다면, 길이를 resize()를 활용하여 절반으로 줄이시오
        if (isEmpty())
            throw new NoSuchElementException();
        if (queue.length >> 2 >= size)
            resize(queue.length >> 1);
        front = after(front, 1);
        var element = queue[front];
        queue[front] = null;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int after(int idx, int offset){
        return (idx + offset) % queue.length;
    }
}
