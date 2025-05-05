package solvedClass.class3.p1389;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<ArrayList<Integer>> adj;
    // 그래프 문제 (BFS)
    // 인접 행렬로 풀기엔 시간 초과가 발생 -> 인접 리스트로 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int minBacon = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 1; i <= n; i++) {
            int[] distance = bfs(i);

            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += distance[j];
            }
            if (sum < minBacon) {
                minBacon = sum;
                ans = i;
            }
        }
        System.out.println(ans);
    }

    static int[] bfs(int start) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : adj.get(curr)) {
                if (distance[next] == -1) {
                    distance[next] = distance[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        return distance;
    }
}
