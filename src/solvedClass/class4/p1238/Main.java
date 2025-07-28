package solvedClass.class4.p1238;

import java.io.*;
import java.util.*;

// 다익스트라 문제
public class Main {

    static class Node implements Comparable<Node>{
        int index;
        int distance;
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }


    static int n, m, x;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        x = Integer.parseInt(inputs[2]);

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        int[] distance1 = new int[n + 1];
        int[] distance2 = new int[n + 1];
        Arrays.fill(distance1, Integer.MAX_VALUE / 2);
        Arrays.fill(distance2, Integer.MAX_VALUE / 2);

        for (int i = 0; i < m; i++) {
            String[] inputs2 = br.readLine().split(" ");
            int a = Integer.parseInt(inputs2[0]);
            int b = Integer.parseInt(inputs2[1]);
            int c = Integer.parseInt(inputs2[2]);
            graph.get(a).add(new Node(b, c));
            reverseGraph.get(b).add(new Node(a, c));
        }

        // N에서 X 까지의 거리 + X에서 N 까지의 거리
        // 다익스트라는 출발점을 기준으로 한 알고리즘 -> 그래프를 뒤집으면 도착점을 기준으로 만들 수 있다.
        dijkstra(x, reverseGraph, distance1);
        dijkstra(x, graph, distance2);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int temp = distance1[i] + distance2[i];
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
    }

    static void dijkstra(int start, ArrayList<ArrayList<Node>> graph, int[] distance) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
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
}
