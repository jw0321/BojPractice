package solvedClass.class4.p1967;

import java.io.*;
import java.util.*;

// BFS,DFS 문제
public class Main {

    static class Node {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(distance, -1);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            int distance = Integer.parseInt(input[2]);

            graph.get(parent).add(new Node(child, distance));
            graph.get(child).add(new Node(parent, distance));
        }

        bfs(1);

        int max = 0;
        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > max) {
                max = distance[i];
                start = i;
            }
        }

        Arrays.fill(distance, -1);
        Arrays.fill(visited, false);
        bfs(start);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > answer) {
                answer  = distance[i];
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int start) {
        visited[start] = true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int now = curr.index;
            int dist = curr.distance;
            distance[now] = dist;

            for (Node node : graph.get(now)) {
                if(!visited[node.index]) {
                    visited[node.index] = true;
                    queue.offer(new Node(node.index, dist + node.distance));
                }
            }
        }
    }
}
