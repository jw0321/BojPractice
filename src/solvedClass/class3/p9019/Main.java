package solvedClass.class3.p9019;

import java.io.*;
import java.util.*;

// BFS 문제 개선된 풀이
public class Main {

    // Map 대신 별도 클래스 사용
    static class Node {
        int num;
        String path;

        public Node(int num, String path) {
            this.num = num;
            this.path = path;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            int input = Integer.parseInt(inputs[0]);
            int target = Integer.parseInt(inputs[1]);

            String result = bfs(input, target);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    // BFS 탐색
    private static String bfs(int input, int target) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        Node firstNode = new Node(input, "");
        queue.offer(firstNode);
        visited[input] = true;
        String[] calc = {"D", "S", "L", "R"};

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (String c : calc) {
                int num = calculate(curr.num, c);
                if (num == target) {
                    return  curr.path + c;
                }
                if (!visited[num]) {
                    visited[num] = true;
                    queue.offer(new Node(num, curr.path + c));
                }
            }
        }
        return "";
    }

    // 연산
    private static int calculate(int num, String calc) {
        switch (calc) {
            case "D":
                return num * 2 % 10000;
            case "S":
                return num == 0 ? 9999 : num - 1;
            case "L":
                return num % 1000 * 10 + num / 1000;
            default:
                return num % 10 * 1000 + num / 10;
        }
    }
}
