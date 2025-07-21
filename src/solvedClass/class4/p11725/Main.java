package solvedClass.class4.p11725;

import java.io.*;
import java.util.*;

// BFS 문제
public class Main {

    static int n;
    // 간선이 적은 트리 이므로 인접 행렬 대신 인접 리스트 사용
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        // 인접 리스트 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : graph.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    parent[i] = curr;
                    queue.offer(i);
                }
            }
        }
    }
}
