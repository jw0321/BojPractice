package solvedClass.class4.p1167;

import java.io.*;
import java.util.*;

// 트리의 지름 문제
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
    static int v;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());
        distance = new int[v + 1];
        Arrays.fill(distance, -1);
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length; j += 2) {
                if (input[j].equals("-1")) {
                    break;
                }
                graph.get(parent).add(new Node(Integer.parseInt(input[j]), Integer.parseInt(input[j + 1])));
            }
        }
        bfs(1);
        int index = 0;
        for (int i = 1; i <= v; i++) {
            if (distance[i] > distance[index]) {
                index = i;
            }
        }
        Arrays.fill(distance, -1);
        bfs(index);
        int max = 0;
        for (int i : distance) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }

    static void bfs(int index) {
        Queue<Node> queue = new ArrayDeque<>();
        distance[index] = 0;
        queue.offer(new Node(index, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int now = curr.index;
            int dist = curr.distance;

            for (Node node : graph.get(now)) {
                if (distance[node.index] == -1) {
                    distance[node.index] = dist + node.distance;
                    queue.offer(new Node(node.index, dist + node.distance));
                }
            }
        }
    }
}
