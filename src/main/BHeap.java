package main;

import java.util.ArrayList;
import java.util.Arrays;

public class BHeap<Key extends Comparable<Key>, Value> {

    private final ArrayList<Entry<Key, Value>> a;
    private int N;

    public BHeap(Entry<Key, Value>[] a, int N) {
        this.a = new ArrayList<>();
        this.a.addAll(Arrays.asList(a));
        this.N = N;
        createHeap();
    }

    // O(N)
    public void createHeap() {
        for (int i = N/2; i > 0; i--) {
            downheap(i);
        }
    }

    public Entry<Key, Value> deleteMin() {
        Entry<Key, Value> min = a.get(1);
        swap(1, N--);
        a.set(N+1, null);
        downheap(1);
        return min;
    }

    public Entry<Key, Value> peek() {
        return a.get(1);
    }

    private void downheap(int i) {
        while (2*i <= N) {
            int k = 2*i;
            if (k < N && greater(a.get(k), a.get(k+1))) k++;
            if (!greater(a.get(i), a.get(k))) break;
            swap(i, k);
            i = k;
        }
    }

    public void insert(Key key, Value value) {
        Entry<Key, Value> temp = new Entry<>(key, value);
        a.set(++N, temp);
        upheap(N);
    }

    private void upheap(int i) {
        while (i > 1 && greater(a.get(i/2), a.get(i))) {
            swap(i/2, i);
            i /= 2;
        }
    }

    public int size() { return N; }

    private boolean greater(Entry<Key, Value> e1, Entry<Key, Value> e2) {
        return e1.getKey().compareTo(e2.getKey()) > 0;
    }

    private void swap(int i, int j) {
        Entry<Key, Value> temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}
