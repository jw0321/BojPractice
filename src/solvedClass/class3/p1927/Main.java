package solvedClass.class3.p1927;

import java.io.*;
import java.util.*;

public class Main {
    // 우선 순위 큐 (힙)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 우선 순위 큐 자료구조 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (pq.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(input);
            }
        }
        System.out.println(sb);
    }
}
