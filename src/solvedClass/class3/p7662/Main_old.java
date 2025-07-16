package solvedClass.class3.p7662;

import java.io.*;
import java.util.*;

public class Main_old {
    // 우선 순위 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> naturalOrder = new PriorityQueue<>();
            PriorityQueue<Integer> reverseOrder = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> elementCount = new HashMap<>();
            int totalElements = 0;

            for (int j = 0; j < k; j++) {
                String[] inputs = br.readLine().split(" ");

                String calc = inputs[0];
                int num = Integer.parseInt(inputs[1]);
                if (calc.equals("I")) {
                    // 삽입 연산
                    elementCount.put(num, elementCount.getOrDefault(num, 0) + 1);
                    totalElements++;

                    naturalOrder.offer(num);
                    reverseOrder.offer(num);

                } else if (totalElements > 0 && num == 1) {
                    // 최댓값 삭제 연산
                    while (!reverseOrder.isEmpty() && elementCount.getOrDefault(reverseOrder.peek(), 0) == 0) {
                        reverseOrder.poll();
                    }
                    int max = reverseOrder.poll();
                    elementCount.put(max, elementCount.get(max) - 1);
                    totalElements--;
                } else if (totalElements > 0 && num == -1) {
                    // 최솟값 삭제 연산
                    while (!naturalOrder.isEmpty() && elementCount.getOrDefault(naturalOrder.peek(), 0) == 0) {
                        naturalOrder.poll();
                    }
                    int min = naturalOrder.poll();
                    elementCount.put(min, elementCount.get(min) - 1);
                    totalElements--;
                }

            }

            if (totalElements > 0) {
                // 최솟값, 최댓값 출력
                while (!naturalOrder.isEmpty() && elementCount.getOrDefault(naturalOrder.peek(), 0) == 0) {
                    naturalOrder.poll();
                }
                while (!reverseOrder.isEmpty() && elementCount.getOrDefault(reverseOrder.peek(), 0) == 0) {
                    reverseOrder.poll();
                }
                sb.append(reverseOrder.peek()).append(" ").append(naturalOrder.peek()).append("\n");
            } else {
                sb.append("EMPTY").append("\n");
            }
        }
        System.out.println(sb);
    }
}
