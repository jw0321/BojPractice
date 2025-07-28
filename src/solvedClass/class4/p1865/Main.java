package solvedClass.class4.p1865;

import java.io.*;
import java.util.*;

// 벨만 포드 문제
public class Main {

    static class Edge {

        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static List<Edge> edges;
    static int n;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            edges = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                String[] input2 = br.readLine().split(" ");
                int s = Integer.parseInt(input2[0]);
                int e = Integer.parseInt(input2[1]);
                int t = Integer.parseInt(input2[2]);

                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }

            for (int j = 0; j < w; j++) {
                String[] input3 = br.readLine().split(" ");
                int s = Integer.parseInt(input3[0]);
                int e = Integer.parseInt(input3[1]);
                int t = Integer.parseInt(input3[2]);

                edges.add(new Edge(s, e, -t));
            }

            if (bellmanFord()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean bellmanFord() {
        distance = new int[n + 1];

        // 최단 거리가 아닌 음수 사이클을 찾는 것이 문제의 조건이므로 거리를 무한대로 설정하지 않아도 되고 어떤 값으로 초기화 해도 작동한다.
        for (int i = 0; i < n; i++) {
            for (Edge edge : edges) {
                if (distance[edge.start] + edge.weight < distance[edge.end]) {
                    distance[edge.end] = distance[edge.start] + edge.weight;
                    if (i == n - 1) {
                        // n - 1 번의 완화를 진행하고도 또 완화가 된다면 음수 사이클이 존재한다.
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


