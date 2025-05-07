package solvedClass.class3.p5430;

import java.io.*;
import java.util.*;

public class Main {
    // Deque 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new ArrayDeque<>();
            String inputArr = br.readLine();
            String[] arrString = inputArr.substring(1, inputArr.length() - 1).split(",");
            for (int j = 0; j < n; j++) {
                dq.offer(Integer.parseInt(arrString[j]));
            }
            boolean isReverse = false;
            boolean error = false;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'R') {
                    isReverse = !isReverse;
                } else if (input.charAt(j) == 'D') {
                    if (!dq.isEmpty()) {
                        if (isReverse) {
                            dq.pollLast();
                        } else {
                            dq.pollFirst();
                        }
                    } else {
                        error = true;
                        break;
                    }
                }
            }

            if (!error) {
                sb.append("[");
                while (!dq.isEmpty()) {
                    if (isReverse) {
                        sb.append(dq.pollLast());
                    } else {
                        sb.append(dq.pollFirst());
                    }
                    if (!dq.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            } else {
                sb.append("error").append("\n");
            }
        }
        System.out.println(sb);
    }
}
