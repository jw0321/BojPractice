package solvedClass.class3.p11286;

import java.io.*;
import java.util.*;

public class Main {
    // 우선순위 큐 + 임의 비교 기준
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int abs_a = Math.abs(a);
            int abs_b = Math.abs(b);
            if (abs_a == abs_b) {
                return a - b;
            } else {
                return abs_a - abs_b;
            }
        });

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
