package solvedClass.class4.p1916;

import java.io.*;
import java.util.*;

// 다익스트라 문제
public class Main {

    static class Node implements Comparable<Node>{

        int index;
        int distance;

        public Node(int index, int distance)  {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    static final int INF = Integer.MAX_VALUE / 2;
    static int n, m;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] distance;

    public static void dijkstra(int start) {
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

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int origin = Integer.parseInt(inputs[0]);
            int dest = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);
            graph.get(origin).add(new Node(dest, cost));
        }

        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);

        dijkstra(start);

        System.out.println(distance[end]);
    }
}
