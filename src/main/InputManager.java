package main;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {

    public ArrayList<String> getInputs() {
        ArrayList<String> inputs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        inputs.add(sc.nextLine()); // insert, delete cnt
        inputs.add(sc.nextLine()); // insertLast item
        inputs.add(sc.nextLine()); // delete index
        return inputs;
    }
}
