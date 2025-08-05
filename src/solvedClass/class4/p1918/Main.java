package solvedClass.class4.p1918;

import java.io.*;
import java.util.*;

// 스택
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        sb.append(stack.pop());
                    }
                }
            } else if (c == '*' || c == '/') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    if (stack.peek() == '*' || stack.peek() == '/') {
                        sb.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(c);
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else {
                sb.append(c);
            }
            if (i == input.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}
