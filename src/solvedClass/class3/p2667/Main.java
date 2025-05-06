package solvedClass.class3.p2667;

import java.io.*;
import java.util.*;

public class Main {
    // 그래프 문제
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    int count = 1;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int x = curr[0];
                        int y = curr[1];
                        int[][] nexts = {
                                {x, y + 1},
                                {x, y - 1},
                                {x + 1, y},
                                {x - 1, y}
                        };
                        for (int[] next : nexts) {
                            if (next[0] >= 0 && next[1] >= 0 && next[0] < n && next[1] < n) {
                                if (!visited[next[0]][next[1]] && matrix[next[0]][next[1]] == 1) {
                                    visited[next[0]][next[1]] = true;
                                    queue.add(new int[]{next[0], next[1]});
                                    count++;
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }

        sb.append(list.size()).append("\n");
        // 배열과 달리 리스트를 정렬할 때는 Collections를 사용해야 한다.
        Collections.sort(list);
        for (int i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
