package main;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {

    public ArrayList<String> getInputs() {
        ArrayList<String> inputs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int N = Integer.parseInt(n);
        inputs.add(n);
        inputs.add(sc.nextLine()); // infixNotation
        for (int i=0; i<N; i++) {
            inputs.add(sc.nextLine()); // operand value
        }
        return inputs;
    }
}
