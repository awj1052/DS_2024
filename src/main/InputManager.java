package main;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {

    public ArrayList<String> getInputs() {
        ArrayList<String> inputs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        inputs.add(sc.nextLine()); // List size
        inputs.add(sc.nextLine()); // List item
        inputs.add(sc.nextLine()); // deleteLast count
        return inputs;
    }
}
