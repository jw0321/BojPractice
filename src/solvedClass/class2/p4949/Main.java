package solvedClass.class2.p4949;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }
            boolean balance = true;

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        balance = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        balance = false;
                        break;
                    }
                } else if (ch == '.') {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                balance = false;
            }

            System.out.println(balance ? "yes" : "no");
        }
    }
}
