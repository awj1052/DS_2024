package main;

import java.util.Arrays;

public class Josephus {

    private final int N;
    private final int K;

    public Josephus(int N, int K) {
        this.N = N;
        this.K = K;
    }

    /**
     * {@link ArrayQueue} 를 사용하여 요세푸스 문제를 해결하는 코드를 작성하세요.
     * <br>요세푸스 문제란, N과 K를 입력했을 때, 1부터 N까지 원형으로 배치하여 K번째의 수들을 계속해서 제거합니다.
     * <br>예를 들어 N=5, K=3 일 때 1 2 3 4 5 에서 1, 2를 건너뛰고 3을 제거합니다. 다음 4, 5를 건너뛰고 1을 제거합니다. 2, 4를 건너뛰고 5를 제거하는 방식입니다.
     * <br>3 1 5 2 4 순서대로 제거되고 이를 반환하면 됩니다.
     * <br>
     * <br>src/test/JosephusTest 를 실행하여 테스트를 하거나 MainJava를 실행하여 입력을 통해 결과를 확인할 수 있습니다.
     * <br>
     * <br>예제 입력
     * <br>7 3
     * <br>
     * <br>예제 출력
     * <br>3 6 2 7 5 1 4
     */

    public int[] solve() {
        // TODO 요세푸스 문제를 해결하는 코드를 ArrayQueue를 사용하여 작성하시오
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        for (int i = 1; i <= N; i++) {
            aq.add(i);
        }
        int[] result = new int[N];
        int pointer = 0;
        while (!aq.isEmpty()) {
            for (int i = 1; i <= K; i++) {
                if (K == i) {
                    result[pointer++] = aq.remove();
                }else {
                    aq.add(aq.remove());
                }
            }
        }

        return result;
    }
}
