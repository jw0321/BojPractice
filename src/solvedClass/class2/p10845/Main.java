package solvedClass.class2.p10845;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            if (inputs[0].equals("push")) {
                int x = Integer.parseInt(inputs[1]);
                push(x);
            } else if (inputs[0].equals("pop")) {
                System.out.println(pop());
            } else if (inputs[0].equals("size")) {
                System.out.println(size());
            } else if (inputs[0].equals("empty")) {
                System.out.println(empty());
            } else if (inputs[0].equals("front")) {
                System.out.println(front());
            } else if (inputs[0].equals("back")) {
                System.out.println(back());
            }
        }
    }

    static List<Integer> list = new ArrayList<>();
    static void push (int x) {
        list.add(x);
    }

    static int pop() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.remove(0);
    }

    static int size() {
        return list.size();
    }

    static int empty() {
        if (list.isEmpty()) {
            return 1;
        }
        return 0;
    }

    static int front() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(0);
    }

    static int back() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(list.size() - 1);
    }
}
