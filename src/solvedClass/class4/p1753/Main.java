package solvedClass.class4.p1753;

import java.io.*;
import java.util.*;

// 다익스트라 문제
public class Main {

    static class Node implements Comparable<Node> {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        // 비용이 낮은 순으로 정렬
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int v, e, start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] distance;

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int dist = curr.distance;
            int now = curr.index;

            if (distance[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                Node next = graph.get(now).get(i);
                int cost = distance[now] + next.distance;

                if (cost < distance[next.index]) {
                    distance[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        start = Integer.parseInt(br.readLine());

        distance = new int[v + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            graph.get(a).add(new Node(b, c));
        }

        dijkstra(start);

        for (int i = 1; i <= v; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}
