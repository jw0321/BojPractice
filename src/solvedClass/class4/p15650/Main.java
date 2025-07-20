package solvedClass.class4.p15650;

import java.io.*;

// 백트래킹 문제
public class Main {

    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        // 답의 형태 정의
        arr = new int[m];
        visited = new boolean[n + 1];

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {
        // 종료 조건
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]);
                if (i != m - 1) {
                    sb.append(" ");
                }
            }
            sb.append('\n');
            return;
        }

        // 가능성 탐색
        for (int i = 1; i <= n; i++) {
            if (depth > 0 && arr[depth - 1] > i) {
                continue;
            }

            if (!visited[i]) {

                visited[i] = true;
                arr[depth] = i;

                dfs(depth + 1);

                // 백트래킹 - 상태 복원
                visited[i] = false;
            }
        }
    }
}

