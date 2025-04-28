package solvedClass.class3.p1697;

import java.io.*;
import java.util.*;

public class Main {

    static int[] distance;

    // 그래프 문제 (BFS)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        distance = new int[100001];
        Arrays.fill(distance, -1);

        if (n == k) {
            System.out.println("0");
            return;
        }

        bfs(n, k);
    }

    static void bfs(int startNode, int targetNode) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(startNode);
        distance[startNode] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == targetNode) {
                System.out.println(distance[currentNode]);
                return;
            }

            int[] nextNodes = {currentNode * 2, currentNode - 1, currentNode + 1};

            for (int nextNode : nextNodes) {
                if (nextNode >= 0 && nextNode <= 100000 && distance[nextNode] == -1) {
                    distance[nextNode] = distance[currentNode] + 1;
                    queue.offer(nextNode);
                }
            }
        }
    }
}