package main;

import java.util.ArrayList;
import java.util.Arrays;

public class MainJava {

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        ArrayList<String> input = inputManager.getInputs();

        int[] inserts = Arrays.stream(input.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] deletes = Arrays.stream(input.get(1).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        CDList<Integer> list = new CDList<>();
        for(int e : inserts) {
            list.insertLast(e);
        }
        for(int e : deletes) {
            list.delete(e);
        }
        System.out.println(list.printall());
    }
}