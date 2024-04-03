package main;

import java.util.ArrayList;

public class MainJava {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        ArrayList<String> input = inputManager.getInputs();

        int N = Integer.parseInt(input.get(0));
        String infixNotation = input.get(1);
        int[] number = new int[N];
        for (int i=0; i<N; i++) {
            number[i] = Integer.parseInt(input.get(i+2));
        }
        String notation = PostNotation.convert(infixNotation);
        PostNotation postNotation = new PostNotation(notation, number);
        System.out.println(postNotation.calcValue());
    }
}