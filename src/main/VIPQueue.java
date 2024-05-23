package main;

public class VIPQueue {

    private final BHeap<Integer, Person> bHeap;

    public VIPQueue(Person[] people) {
        bHeap = new BHeap<>(toEntries(people), people.length);
    }

    /**
     * 차차는 드디어 종강을 했다!
     * <br>방학을 재밌게 지내고 싶은 차차는 해외여행을 가려고 인천공항에 왔다.
     * <br>차차는 부유해서 남는 시간동안 라운지에서 쉬려고 한다.
     * <br>
     * <br>그러나 라운지에 들어가려는 사람이 많아 길이 엄청 길다.
     * <br>라운지 직원은 기다리는 사람의 priority의 값이 큰 사람부터 들여보내기로 했다.
     * <br>기다리는 것을 싫어하는 차차는 먼저 들어가는 M명을 알고 싶어한다.
     * <br>여러분은 BHeap과 VIPQueue를 이용하여 차차를 도와주려고 한다.
     * <br>그러나 노트북이 뮤온 입자에 노출되어 VIPQueue의 일부가 손실되었다.
     * <br>VIPQueue를 문제에 맞게 잘 고쳐보자.
     * <br>
     * <br>기다리는 사람은 N명이고, 차차가 알고 싶어하는 먼저 들어가는 사람의 수는 M명이다. (N>=M)
     * @see Entry
     * @return people -> Entry[]
     */
    private Entry<Integer, Person>[] toEntries(Person[] people) {
        Entry<Integer, Person>[] entries = new Entry[people.length+1];
        for(int i=0; i<people.length; i++) {
            // TODO Entry 생성자의 인자값을 올바르게 작성하시오.
            entries[i+1] = new Entry<>(null, null);
        }
        return entries;
    }

    /**
     * @see VIPQueue#toEntries(Person[])
     */
    public void add(Person person) {
        // TODO insert 의 인자값을 올바르게 작성하시오.
        bHeap.insert(null, null);
    }

    public Person pop() {
        return bHeap.deleteMin().getValue();
    }

    public Person peek() {
        return bHeap.peek().getValue();
    }
}
