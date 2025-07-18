package solvedClass.class3.p9019;

import java.io.*;
import java.util.*;

public class Main_0 {

    // BFS 문제
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            int input = Integer.parseInt(inputs[0]);
            int target = Integer.parseInt(inputs[1]);

            Queue<Map<Integer, String>> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            Map<Integer, String> map = new HashMap<>();
            map.put(input, "");
            queue.offer(map);
            visited[input] = true;

            String[] calc = {"D", "S", "L", "R"};
            while (!queue.isEmpty()) {
                Map<Integer, String> curr = queue.poll();
                Map<Integer, String> next = new HashMap<>();
                boolean isFound = false;
                for (String c : calc) {
                    for (Map.Entry<Integer, String> entry : curr.entrySet()) {
                        int num = calculate(entry.getKey(), c);
                        if (num == target) {
                            sb.append(entry.getValue() + c).append('\n');
                            isFound = true;
                            break;
                        }
                        if (!visited[num]) {
                            visited[num] = true;
                            next.put(num, entry.getValue() + c);
                        }
                    }
                    if (isFound) {
                        break;
                    }
                }
                if (isFound) {
                    break;
                }
                queue.offer(next);
            }
        }
        System.out.println(sb);
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
