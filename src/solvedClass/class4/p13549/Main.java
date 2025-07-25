package solvedClass.class4.p13549;

import java.io.*;
import java.util.*;

// BFS 문제
public class Main {

    static int n, k;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        distance = new int[100001];
        Arrays.fill(distance, -1);

        bfs();
    }

    public static void bfs() {
        distance[n] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == k) {
                System.out.println(distance[curr]);
                return;
            }

            if (curr * 2 <= 100000 && distance[curr * 2] == -1) {
                distance[curr * 2] = distance[curr];
                queue.offer(curr * 2);
            }

            if (curr - 1 >= 0 && distance[curr - 1] == -1) {
                distance[curr - 1] = distance[curr] + 1;
                queue.offer(curr - 1);
            }

            if (curr + 1 <= 100000 && distance[curr + 1] == -1) {
                distance[curr + 1] = distance[curr] + 1;
                queue.offer(curr + 1);
            }


        }
    }
}
