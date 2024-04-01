package main;

import java.util.ArrayList;

public class MainJava {

    private int N;
    private String infixNotation;
    private int[] number;

    public MainJava(int N, String infixNotation, int[] number) {
        this.N = N;
        this.infixNotation = infixNotation;
        this.number = number;
    }

    public int getResult() {
        PostNotation postNotation = PostNotation.getInstance(N, infixNotation, number);
        return postNotation.calcValue();
    }

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        ArrayList<String> input = inputManager.getInputs();

        int N = Integer.parseInt(input.get(0));
        String infixNotation = input.get(1);
        int[] number = new int[N];
        for (int i=0; i<N; i++) {
            number[i] = Integer.parseInt(input.get(i+2));
        }
        MainJava mainJava = new MainJava(N, infixNotation, number);
        System.out.println(mainJava.getResult());

    }
}