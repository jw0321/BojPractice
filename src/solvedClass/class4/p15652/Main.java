package solvedClass.class4.p15652;

import java.io.*;

// 백트래킹 문제
public class Main {

    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[m];

        dfs(0, 1);
        System.out.println(sb);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1, i);
        }
    }
}
