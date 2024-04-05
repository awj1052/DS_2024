package main;

import java.util.ArrayList;
import java.util.Arrays;

public class MainJava {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        ArrayList<String> input = inputManager.getInputs();
        int[] inputs = Arrays.stream(input.get(0).split(" ")).mapToInt(Integer::parseInt).toArray();
        Josephus josephus = new Josephus(inputs[0], inputs[1]);
        Arrays.stream(josephus.solve()).forEach(e -> System.out.print(e + " "));
    }
}