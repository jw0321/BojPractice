package solvedClass.class2.p1874;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < n ; i++) {
            if (!stack.isEmpty() && arr[i] < stack.peek()) {
                System.out.println("NO");
                return;
            }
            while (true) {
                if (stack.isEmpty() || arr[i] > stack.peek()) {
                    stack.push(num);
                    num++;
                    sb.append("+").append('\n');
                } else {
                    stack.pop();
                    sb.append("-").append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
