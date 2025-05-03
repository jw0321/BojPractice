package solvedClass.class3.p11279;

import java.io.*;
import java.util.*;

public class Main {
    // 우선 순위 큐 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input != 0) {
                // 삽입 연산
                pq.offer(input);
            } else {
                // 제거 연산
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
