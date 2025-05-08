package solvedClass.class3.p16928;

import java.io.*;
import java.util.*;

public class Main {

    // 그래프 문제 (BFS)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[] distance = new int[101];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(distance, -1);
        for (int i = 0; i < n; i++) {
            String[] inputs2 = br.readLine().split(" ");
            int a = Integer.parseInt(inputs2[0]);
            int b = Integer.parseInt(inputs2[1]);
            map.put(a, b);
        }
        for (int i = 0; i < m; i++) {
            String[] inputs3 = br.readLine().split(" ");
            int a = Integer.parseInt(inputs3[0]);
            int b = Integer.parseInt(inputs3[1]);
            map.put(a, b);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = curr + 1; i <= curr + 6; i++) {
                if (i <= 100) {
                    if (map.containsKey(i)) {
                        int next = map.get(i);
                        if (distance[next] == -1) {
                            distance[next] = distance[curr] + 1;
                            queue.offer(next);
                        }
                    } else {
                        if (distance[i] == -1) {
                            distance[i] = distance[curr] + 1;
                            queue.offer(i);
                        }
                    }
                }
            }
        }
        System.out.println(distance[100]);
    }
}
