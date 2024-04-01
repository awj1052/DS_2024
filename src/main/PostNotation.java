package main;

import java.util.Stack;

public class PostNotation {

    private int N;
    private String notation;
    private int[] number;

    private PostNotation(int N, String notation, int[] number) {
        this.N = N;
        this.notation = notation;
        this.number = number;
    }

    public int calcValue() {
        // TODO : asd
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<notation.length(); i++) {
            char temp = notation.charAt(i);
            if (temp >= 'A' && temp <= 'Z') {
                stack.add(getNumber(temp));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (temp) {
                    case '+':
                        stack.add(operand1 + operand2);
                        break;
                    case '-':
                        stack.add(operand1 - operand2);
                        break;
                    case '*':
                        stack.add(operand1 * operand2);
                        break;
                    case '/':
                        stack.add(operand1 / operand2);
                }
            }
        }
        return stack.pop();
    }

    private int getNumber(char alphabet) {
        return number[alphabet - 'A'];
    }

    public static PostNotation getInstance(int N, String infixNotation, int[] number) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<infixNotation.length(); i++) {
            char element = infixNotation.charAt(i);
            if('A' <= element && element <= 'Z') {
                res.append(element);
            } else {
                if (element == '(') {
                    stack.add('(');
                } else if (element == '*' || element == '/') {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        res.append(stack.pop());
                    }
                    stack.add(element);
                } else if (element == '+' || element == '-') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        res.append(stack.pop());
                    }
                    stack.add(element);
                } else { // )
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        res.append(stack.pop());
                    }
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return new PostNotation(N, res.toString(), number);
    }
}
