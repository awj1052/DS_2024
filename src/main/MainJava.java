package main;

import java.util.ArrayList;
import java.util.Arrays;

public class MainJava {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        ArrayList<String> input = inputManager.getInputs();

        int N = Integer.parseInt(input.get(0));
        int[] inputs = Arrays.stream(input.get(1).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int deleteCnt = Integer.parseInt(input.get(2));

        ArrList<Integer> list = new ArrList<>();
        for(int e : inputs) {
            list.insertLast(e);
        }
        while(deleteCnt-->0) list.deleteLast();
        System.out.println(list.printall());
    }
}